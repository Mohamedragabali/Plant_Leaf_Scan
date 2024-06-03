package com.mohamedragabali.plantleafscan.ui.advice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mohamedragabali.plantleafscan.databinding.FragmentAdviceBinding
import com.mohamedragabali.plantleafscan.domain.data.DataSource


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
        val adapter = AdviceAdapter(DataSource.allAdvice())
        binding.adviceRecyclerView.adapter = adapter
    }



}