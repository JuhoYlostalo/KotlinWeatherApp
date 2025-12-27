package com.example.myapplication.models
import kotlinx.serialization.Serializable

@Serializable
data class WeatherRes(
    val name: String,
    val main: Main,
    val weather: List<Weather>,
    val wind: Wind
)

@Serializable
data class Main(
    val temp: Double
)

@Serializable
data class Weather(
    val description: String,
    val icon: String
)

@Serializable
data class Wind(
    val speed: Double
)
