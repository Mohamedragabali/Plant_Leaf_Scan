package com.mohamedragabali.plantleafscan.ui.home.slider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamedragabali.plantleafscan.R
import com.mohamedragabali.plantleafscan.databinding.ItemSlideBinding

class SliderAdapter(val list: List<String> ) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_slide , parent,false)
        return SliderViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.binding.adviceText.text = list[position]
    }

    class SliderViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem ) {
        val binding = ItemSlideBinding.bind(viewItem)
    }
}
