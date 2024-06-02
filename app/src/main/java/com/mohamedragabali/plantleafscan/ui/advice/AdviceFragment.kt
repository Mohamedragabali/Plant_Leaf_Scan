package com.mohamedragabali.plantleafscan.ui.advice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mohamedragabali.plantleafscan.R
import com.mohamedragabali.plantleafscan.databinding.FragmentAdviceBinding
import com.mohamedragabali.plantleafscan.databinding.FragmentScanBinding


class AdviceFragment : Fragment() {
    private lateinit var binding :FragmentAdviceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdviceBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AdviceAdapter(
            listOf("Water your plants regularly, but avoid overwatering to prevent root rot issues."
                ,"Place plants in appropriate lighting conditions for their specific species' growth requirements."
                ,"Ensure proper drainage in pots to prevent water logging and promote healthy root development."
                ,"Use quality potting soil that matches the needs of your plant type for best results."
                ,"Fertilize plants periodically with the right nutrients to encourage vigorous growth and flowering."
                ,"Prune dead or yellowing leaves to encourage new growth and maintain plant health."
                ,"Rotate potted plants periodically to ensure even light exposure and balanced growth."
                ,"Monitor for pests and diseases regularly, treating them promptly to prevent spread."
                ,"Group plants with similar care requirements together to simplify watering and maintenance routines."
                ,"Mist tropical plants occasionally to maintain humidity levels and keep leaves looking fresh."
                ,"Repot plants annually or when roots outgrow their containers to encourage growth."
                ,"Keep leaves clean by gently wiping with a damp cloth to remove dust."
                ,"Provide support for climbing plants with stakes or trellises to help them grow upright."
                ,"Avoid placing plants near drafts or vents to prevent stress and damage."
                ,"Check soil moisture with a finger test before watering to avoid overwatering."))
        binding.adviceRecyclerView.adapter = adapter
    }



}