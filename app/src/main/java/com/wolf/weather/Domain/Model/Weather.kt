package com.wolf.weather.Domain.Model

data class Weather(
    val cityName: String,
    val temperature: Double,
    val humidity: Int,
    val pressure: Int,
    val weatherMain: String,
    val description: String,
    val icon: String,
    val windSpeed : Double

)
