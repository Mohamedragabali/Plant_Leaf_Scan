package com.mohamedragabali.plantleafscan.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamedragabali.plantleafscan.R
import com.mohamedragabali.plantleafscan.databinding.ItemHeaderBinding
import com.mohamedragabali.plantleafscan.databinding.ItemPlantListBinding
import com.mohamedragabali.plantleafscan.databinding.ItemSliderListBinding
import com.mohamedragabali.plantleafscan.domain.HomeItem
import com.mohamedragabali.plantleafscan.domain.HomeItemType
import com.mohamedragabali.plantleafscan.ui.home.plant.PlantAdapter
import com.mohamedragabali.plantleafscan.ui.home.slider.SliderAdapter

class HomeAdapter(private var list : List<HomeItem> ) : RecyclerView.Adapter<HomeAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
         when(viewType){
            HomeItemType.HEADER.ordinal->{
                val view =LayoutInflater.from(parent.context).inflate(R.layout.item_header,parent,false)
                return HeaderViewHolder(view)
            }
            HomeItemType.SLIDER.ordinal ->{
                val view =LayoutInflater.from(parent.context).inflate(R.layout.item_slider_list,parent,false)
                return SliderListViewHolder(view)

            }
            HomeItemType.PLANT.ordinal ->{
                val view =LayoutInflater.from(parent.context).inflate(R.layout.item_plant_list,parent,false)
                return PlantListViewHolder(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int =list.size

    override fun getItemViewType(position: Int)= list[position].type.ordinal

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = list[position]
        when(holder){
            is HeaderViewHolder -> {
                item as HomeItem.Header
            }
            is SliderListViewHolder -> {
                item as HomeItem.Slider
                val adapter = SliderAdapter(item.slideText)
                holder.binding.sliderRecyclerView.adapter = adapter
            }
            is PlantListViewHolder ->{
                item as HomeItem.Plant
                holder.binding.categoryName.text = item.plantNameText
                val adapter = PlantAdapter(item.plant)
                holder.binding.plantImagesRecyclerView.adapter = adapter
            }
        }
    }



    abstract class BaseViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem)

    class HeaderViewHolder(viewItem: View) :  BaseViewHolder(viewItem) {
        val binding = ItemHeaderBinding.bind(viewItem)
    }

    class SliderListViewHolder(viewItem: View) :  BaseViewHolder(viewItem) {
        val binding = ItemSliderListBinding.bind(viewItem)
    }



    class PlantListViewHolder(viewItem: View) :  BaseViewHolder(viewItem) {
        val binding = ItemPlantListBinding.bind(viewItem)
    }

}