package com.wolf.weather.Data.RepositoryImplementation

import com.wolf.weather.Data.Remote.dto.WeatherDto
import com.wolf.weather.Data.Services.WeatherAPIservice
import com.wolf.weather.Domain.Repository.Weather.WeatherRepository
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import com.wolf.weather.Domain.Util.Result

class WeatherRepositoryImpl(
    private val apiService: WeatherAPIservice
) : WeatherRepository {
    override suspend fun getWeatherData(city: String): Result<WeatherDto> {
        return try {
            val response = apiService.client.get("/data/2.5/weather") {
                parameter("q", city)
                parameter("appid", apiService.apiKey)
                parameter("units", "metric")
            }.body<WeatherDto>()
            Result.Success(response)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error("Failed to fetch weather data: ${e.localizedMessage}")
        }
    }
}