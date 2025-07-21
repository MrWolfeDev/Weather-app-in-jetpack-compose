package com.wolf.weather.Domain.UseCase

import com.wolf.weather.Data.Mapper.toDomain
import com.wolf.weather.Data.Remote.dto.WeatherDto
import com.wolf.weather.Domain.Model.Weather
import com.wolf.weather.Domain.Repository.Weather.WeatherRepository
import com.wolf.weather.Domain.Util.Result

class GetWeatherUseCase(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(city: String): Result<Weather> {
        return when (val result = repository.getWeatherData(city)) {
            is Result.Success -> {
                val weatherDto = result.data // this is WeatherDto
                Result.Success(weatherDto.toDomain())
            }            is Result.Error -> Result.Error(result.message)
            else -> Result.Error("Unexpected state")
        }
    }
}