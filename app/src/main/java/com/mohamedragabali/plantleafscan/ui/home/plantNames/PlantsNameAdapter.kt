package com.mohamedragabali.plantleafscan.ui.home.plantNames

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamedragabali.plantleafscan.R
import com.mohamedragabali.plantleafscan.databinding.ItemPlantNameBinding

class PlantsNameAdapter(val list: List<String> ) : RecyclerView.Adapter<PlantsNameAdapter.PlantsNameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantsNameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plant_name , parent,false)
        return PlantsNameViewHolder(view)
    }


    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PlantsNameViewHolder, position: Int) {
        holder.binding.plantName.text = list[position]
    }

    class PlantsNameViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem ) {
        val binding = ItemPlantNameBinding.bind(viewItem)
    }
}