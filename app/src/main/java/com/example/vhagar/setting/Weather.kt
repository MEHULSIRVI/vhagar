package com.example.vhagar.setting

import com.example.vhagar.setting.Clouds
import com.example.vhagar.setting.Coord
import com.example.vhagar.setting.Main
import com.example.vhagar.setting.Rain
import com.example.vhagar.setting.Sys
import com.example.vhagar.setting.WeatherX
import com.example.vhagar.setting.Wind

data class Weather(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val rain: Rain,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<WeatherX>,
    val wind: Wind
)