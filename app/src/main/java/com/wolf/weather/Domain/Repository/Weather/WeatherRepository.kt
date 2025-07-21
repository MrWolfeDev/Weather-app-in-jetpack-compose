package com.wolf.weather.Domain.Repository.Weather

import com.wolf.weather.Data.Remote.dto.WeatherDto
import com.wolf.weather.Domain.Util.Result

interface WeatherRepository{
    suspend fun getWeatherData(city: String): Result<WeatherDto>
}