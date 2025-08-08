package com.wolf.weather.Presentation.di

import com.wolf.weather.Data.RepositoryImplementation.WeatherRepositoryImpl
import com.wolf.weather.Data.Services.WeatherAPIservice
import com.wolf.weather.Domain.Repository.Weather.WeatherRepository
import com.wolf.weather.Domain.UseCase.GetWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    @Singleton
    fun provideWeatherUseCase(repository: WeatherRepository): GetWeatherUseCase {
        return GetWeatherUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideWeatherRepository(apiService: WeatherAPIservice): WeatherRepository {
        return WeatherRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideWeatherApiService(): WeatherAPIservice {
        return WeatherAPIservice(
            apiKey = "your api key "
        )
    }

}
