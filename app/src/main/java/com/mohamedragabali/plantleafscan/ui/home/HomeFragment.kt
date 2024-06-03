package com.mohamedragabali.plantleafscan.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mohamedragabali.plantleafscan.databinding.FragmentHomeBinding
import com.mohamedragabali.plantleafscan.domain.HomeItem
import com.mohamedragabali.plantleafscan.domain.data.DataSource

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter =
            HomeAdapter(
                listOf(
                    HomeItem.Header(),
                    HomeItem.Slider(DataSource.getFourRandomAdvice()),
                    HomeItem.Plant(DataSource.getPlantDiseaseHasText("Apple") , "Apple")
                    ,HomeItem.Plant(DataSource.getPlantDiseaseHasText("Blueberry"), "Blueberry")
                    ,HomeItem.Plant(DataSource.getPlantDiseaseHasText("Cherry"), "Cherry")
                    ,HomeItem.Plant(DataSource.getPlantDiseaseHasText("Grape"), "Grape")
                    ,HomeItem.Plant(DataSource.getPlantDiseaseHasText("Orange"), "Orange")
                    ,HomeItem.Plant(DataSource.getPlantDiseaseHasText("Peach"), "Peach")
                    ,HomeItem.Plant(DataSource.getPlantDiseaseHasText("Pepper"), "Pepper")
                    ,HomeItem.Plant(DataSource.getPlantDiseaseHasText("Potato"), "Potato")
                    ,HomeItem.Plant(DataSource.getPlantDiseaseHasText("Raspberry"), "Raspberry")
                    ,HomeItem.Plant(DataSource.getPlantDiseaseHasText("Soybean"), "Soybean")
                    ,HomeItem.Plant(DataSource.getPlantDiseaseHasText("Squash"), "Squash")
                    ,HomeItem.Plant(DataSource.getPlantDiseaseHasText("Strawberry"), "Strawberry")
                    ,HomeItem.Plant(DataSource.getPlantDiseaseHasText("Tomato"), "Tomato")
                )
            )
        binding.homeRecyclerView.adapter = adapter
    }



}