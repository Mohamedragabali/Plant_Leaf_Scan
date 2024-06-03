package com.mohamedragabali.plantleafscan.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamedragabali.plantleafscan.R
import com.mohamedragabali.plantleafscan.databinding.ItemPlantSearchBinding

class SearchAdapter (private var list: List<Pair<Int,String>>) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plant_search,parent,false)
        return SearchViewHolder(view)
    }

    override fun getItemCount()= list.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.binding.diseaseName.text = list[position].second
        holder.binding.imagePlant.setImageResource(list[position].first)
    }

    fun setData(newList:List<Pair<Int,String>>){
        list = newList
        notifyDataSetChanged()
    }

    class SearchViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem){
        val binding = ItemPlantSearchBinding.bind(viewItem)
    }
}