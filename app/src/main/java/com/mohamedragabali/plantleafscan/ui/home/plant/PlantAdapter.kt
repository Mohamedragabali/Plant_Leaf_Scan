package com.mohamedragabali.plantleafscan.ui.home.plant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamedragabali.plantleafscan.R
import com.mohamedragabali.plantleafscan.databinding.ItemPlantBinding

class PlantAdapter(val list: List<Pair<Int,String>>)  : RecyclerView.Adapter<PlantAdapter.PlantImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plant , parent,false)
        return PlantImageViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PlantImageViewHolder, position: Int) {
       holder.binding.imagePlant.setImageResource(list[position].first)
        holder.binding.diseaseName.text=list[position].second
    }

    class PlantImageViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem ) {
        val binding = ItemPlantBinding.bind(viewItem)
    }
}