package com.wolf.weather.Presentation.HomeScreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wolf.weather.Domain.Model.Weather
import com.wolf.weather.Domain.Util.Result


@Composable
fun WeatherInfoCard(state: Result<Weather>) {
    // Animation for card entrance
    val scale = remember { Animatable(0.8f) }
    val alpha = remember { Animatable(0f) }
    LaunchedEffect(state) {
        scale.animateTo(1f, animationSpec = tween(500, easing = FastOutSlowInEasing))
        alpha.animateTo(1f, animationSpec = tween(500, easing = FastOutSlowInEasing))
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.3f) // Glassmorphism effect
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .blur(10.dp) // Subtle blur for glass effect
            .alpha(alpha.value)
            .scale(scale.value)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is com.wolf.weather.Domain.Util.Result.Idle -> {
                    Text(
                        text = "Discover the weather! Enter a city name to get started.",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Medium,
                            color = Color.White.copy(alpha = 0.8f),
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp
                        ),
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }

                is com.wolf.weather.Domain.Util.Result.Loading -> {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.size(48.dp)
                    )
                }

                is com.wolf.weather.Domain.Util.Result.Success -> {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = state.data.cityName,
                            style = MaterialTheme.typography.headlineLarge.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                                color = Color.White
                            )
                        )
                        Text(
                            text = "${state.data.temperature}°C",
                            style = MaterialTheme.typography.displayMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 48.sp,
                                color = Color(0xFFFFD700) // Gold for temperature
                            )
                        )
                        Text(
                            text = state.data.weatherMain,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Medium,
                                color = Color.White
                            )
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            WeatherDetailItem(label = "Humidity", value = "${state.data.humidity}%")
                            WeatherDetailItem(
                                label = "Pressure",
                                value = "${state.data.pressure} hPa"
                            )
                            WeatherDetailItem(label = "Wind", value = "${state.data.windSpeed} m/s")
                        }
                        Text(
                            text = state.data.description,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Color.White.copy(alpha = 0.8f),
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }

                is Result.Error -> {
                    Text(
                        text = state.message,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFFFF6B6B), // Red for error
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp
                        ),
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }

                is Result.Error -> TODO()
                   Result.Idle -> TODO()
                   Result.Loading -> TODO()
                is Result.Success<*> -> TODO()
            }
        }
    }
}
