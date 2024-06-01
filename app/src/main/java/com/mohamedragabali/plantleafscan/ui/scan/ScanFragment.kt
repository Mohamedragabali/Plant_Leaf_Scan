package com.mohamedragabali.plantleafscan.ui.scan

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.mohamedragabali.plantleafscan.databinding.FragmentScanBinding
import com.mohamedragabali.plantleafscan.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.nio.ByteBuffer
import java.nio.ByteOrder


class ScanFragment : Fragment() {

    private lateinit var binding :FragmentScanBinding
    private val GALLERY_PERMISSION_REQUEST_CODE = 102
    private var imageUri: Uri? = null
    private var labels = emptyArray<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScanBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            val bufferedReader = BufferedReader(InputStreamReader(requireActivity().assets.open("imageLabels.txt")))
            bufferedReader.useLines { lines ->
                labels = lines.toList().toTypedArray()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        binding.folder.setOnClickListener {

            if (checkGalleryPermission()) {
                pickImageFromGallery()
            } else {
                requestExternalStoragePermission()
            }
        }

        binding.buttonScan.setOnClickListener {
            if(imageUri == null ){
                 Snackbar.make(it, "Please first select image", Snackbar.LENGTH_LONG).show()
            }
            else{
                //(1, 224, 224, 3)
                var bitmap = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, imageUri)
                val resized = Bitmap.createScaledBitmap(bitmap, 200, 200, true)
                val byteBuffer: ByteBuffer = bitmapToByteBuffer(resized, 200, 200)

                val model = Model.newInstance(requireActivity())



                // Creates inputs for reference.
                val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 200, 200, 3), DataType.FLOAT32)
                inputFeature0.loadBuffer(byteBuffer)

                // Runs model inference and gets result.
                val outputs = model.process(inputFeature0)
                val outputFeature0 = outputs.outputFeature0AsTensorBuffer


                val predictedResult = labels[getMax(outputFeature0.floatArray)]
                binding.result.text = "Prediction: $predictedResult"
                model.close()
            }
        }
    }

    fun bitmapToByteBuffer(image: Bitmap, width: Int, height: Int): ByteBuffer {
        val byteBuffer: ByteBuffer = ByteBuffer.allocateDirect(4 * width * height * 3)
        byteBuffer.order(ByteOrder.nativeOrder())
        // get 1D array of width * height pixels in image
        val intValues = IntArray(width * height)
        image.getPixels(intValues, 0, image.width, 0, 0, image.width, image.height)
        // iterate over pixels and extract R, G, and B values. Add to bytebuffer.
        var pixel = 0
        for (i in 0 until width) {
            for (j in 0 until height) {
                val `val` = intValues[pixel++] // RGB

                ///
                byteBuffer.putFloat((`val` shr 16 and 0xFF) * (1f / 199f))
                byteBuffer.putFloat((`val` shr 8 and 0xFF) * (1f / 199f))
                byteBuffer.putFloat((`val` and 0xFF) * (1f / 199f))
            }
        }
        return byteBuffer
    }
    fun getMax(arr: FloatArray): Int {
        var max = 0
        for (i in 1 until arr.size) {
            Log.i("MY_TAG" , "${arr[i]}")
            if (arr[i] > arr[max]) max = i
        }
        return max
    }

    private fun checkGalleryPermission(): Boolean {
        return if (ContextCompat.checkSelfPermission(
                requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            false
        } else true
    }
    private fun requestExternalStoragePermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            GALLERY_PERMISSION_REQUEST_CODE
        )
    }
    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        galleryActivityResultLauncher.launch(intent)
    }
    private val galleryActivityResultLauncher = registerForActivityResult<Intent, ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            val data = result.data
            imageUri = data!!.data
            binding.image.setImageURI(imageUri)
        } else {
            Toast.makeText(requireContext(), "something went wrong", Toast.LENGTH_LONG)
        }
    }
}