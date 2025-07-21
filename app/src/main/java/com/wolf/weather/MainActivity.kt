package com.wolf.weather

import WeatherScreen
import com.wolf.weather.Presentation.ViewModel.WeatherViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.wolf.weather.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherTheme {
                val weatherViewModel: WeatherViewModel = hiltViewModel()
                WeatherScreen(viewModel = weatherViewModel)
            }
        }
    }
}
