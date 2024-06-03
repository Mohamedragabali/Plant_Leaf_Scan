package com.mohamedragabali.plantleafscan.domain

sealed class HomeItem(val type: HomeItemType) {
    class Header : HomeItem(HomeItemType.HEADER)
    data class Slider(val slideText: List<String>) : HomeItem(HomeItemType.SLIDER)
    data class Plant(val plant: List<Pair<Int, String>>  , val plantNameText : String) : HomeItem(HomeItemType.PLANT)
}