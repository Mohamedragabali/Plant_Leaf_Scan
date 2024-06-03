package com.mohamedragabali.plantleafscan.domain

sealed class HomeItem(val type: HomeItemType) {
    class Header : HomeItem(HomeItemType.HEADER)
    data class Slider(val slideText :List<String>): HomeItem(HomeItemType.SLIDER)
    data class PlantName(val plantNames: List<String>): HomeItem(HomeItemType.PLANT_NAME)
    data class Plant(val plant:List<Pair<Int,String>>): HomeItem(HomeItemType.PLANT)
}