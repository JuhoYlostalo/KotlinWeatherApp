package com.example.myapplication.data

import android.util.Log
import com.example.myapplication.BuildConfig
import com.example.myapplication.models.WeatherRes
import com.example.myapplication.network.WeatherClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class WeatherRepository {
    private val client = WeatherClient.client
    private val apiKey = BuildConfig.WEATHER_API_KEY

    suspend fun getWeatherData(): WeatherRes {

        //i could not extract this as a string
        return client.get("https://api.openweathermap.org/data/2.5/weather?lat=65.0121&lon=25.4651&units=metric&appid=$apiKey").body()
    }
}

