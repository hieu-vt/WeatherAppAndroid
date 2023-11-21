package com.plcoding.weatherapp.data.repository

import com.plcoding.weatherapp.data.mappers.toWeatherDataInfo
import com.plcoding.weatherapp.data.remote.WeatherApi
import com.plcoding.weatherapp.domain.repository.WeatherRepository
import com.plcoding.weatherapp.domain.util.Resource
import com.plcoding.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, log: Double) : Resource<WeatherInfo>{
        return try {
            Resource.Success(
                data = api.getWeatherData(lat = lat, log = log).toWeatherDataInfo()
            )
        }catch (error: Exception) {
            error.printStackTrace()
            Resource.Error(error.message ?: "An error occurred")
        }
    }
}