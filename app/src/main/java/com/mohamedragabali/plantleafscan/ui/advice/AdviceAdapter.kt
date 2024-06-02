package com.mohamedragabali.plantleafscan.ui.advice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamedragabali.plantleafscan.R
import com.mohamedragabali.plantleafscan.databinding.ItemAdviceBinding

class AdviceAdapter(val list: List<String>) : RecyclerView.Adapter<AdviceAdapter.AdviceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdviceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_advice , parent,false)
        return AdviceViewHolder(view)
    }

    override fun getItemCount()= list.size

    override fun onBindViewHolder(holder: AdviceViewHolder, position: Int) {
        val currentAdvice = list[position]
        holder.binding.adviceText.text = currentAdvice
    }

    class AdviceViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem ) {
        val binding = ItemAdviceBinding.bind(viewItem)
    }
}