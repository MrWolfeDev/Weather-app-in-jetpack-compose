package com.wolf.weather.Presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wolf.weather.Domain.Model.Weather
import com.wolf.weather.Domain.UseCase.GetWeatherUseCase
import com.wolf.weather.Domain.Util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<Result<Weather>>(Result.Idle)
    val uiState: StateFlow<Result<Weather>> = _uiState.asStateFlow()

    private val _city = MutableStateFlow("")
    val city: StateFlow<String> = _city.asStateFlow()

    fun updateCity(city: String) {
        _city.value = city
        if (city.isBlank()) {
            _uiState.value = Result.Idle
        }
    }

    fun searchWeather() {
        viewModelScope.launch {
            if (_city.value.isBlank()) {
                _uiState.value = Result.Error("Please enter a city name")
                return@launch
            }
            _uiState.value = Result.Loading
            _uiState.value = getWeatherUseCase(_city.value)
        }
    }
}
