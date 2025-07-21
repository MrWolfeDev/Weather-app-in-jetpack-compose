package com.wolf.weather.Presentation.state

import com.wolf.weather.Data.Remote.dto.WeatherDto
import com.wolf.weather.Domain.Model.Weather


data class WeatherUiState(
    val city: String = "",
    val isLoading: Boolean = false,
    val weather: Weather? = null,
    val error: String? = null,
    val snackbarMessage: String? = null
)
