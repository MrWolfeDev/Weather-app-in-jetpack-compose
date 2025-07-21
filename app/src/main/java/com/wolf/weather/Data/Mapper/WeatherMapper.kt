package com.wolf.weather.Data.Mapper


import com.wolf.weather.Data.Remote.dto.WeatherDto
import com.wolf.weather.Domain.Model.Weather

fun WeatherDto.toDomain(): Weather {
    return Weather(
        cityName = this.name,
        temperature = this.main.temp,
        humidity = this.main.humidity,
        pressure = this.main.pressure,
        windSpeed = this.wind.speed,
        weatherMain = this.weather.firstOrNull()?.main ?: "N/A",
        description = this.weather.firstOrNull()?.description ?: "N/A",
        icon = this.weather.firstOrNull()?.icon ?: "01d"
    )
}