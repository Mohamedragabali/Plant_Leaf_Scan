package com.mohamedragabali.plantleafscan.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import com.mohamedragabali.plantleafscan.databinding.FragmentSearchBinding
import com.mohamedragabali.plantleafscan.domain.data.DataSource

class SearchFragment : Fragment()  {
    lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SearchAdapter(emptyList())
        binding.searchRecyclerView.adapter = adapter
        binding.searchView.setOnQueryTextListener(object :OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText != null ){
                   val list =  DataSource.getPlantDiseaseHasText(newText)
                    adapter.setData(list)
                }
                if(newText == ""){adapter.setData(emptyList())}
               return true
            }
        })

    }
}