package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.WeatherRepository
import com.example.myapplication.models.WeatherRes
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

data class WeatherUiState(
    val weatherData: WeatherRes? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

class WeatherViewModel : ViewModel() {

    private val repository = WeatherRepository()
    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    init {
        startWeatherUpdates()
    }

    private fun startWeatherUpdates() {
        viewModelScope.launch {
            while (isActive) {
                fetchData()
                delay(10 * 60 * 1000L)
            }
        }
    }

    private suspend fun fetchData() {
        if (_uiState.value.weatherData == null) {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
        }
        
        try {
            val data = repository.getWeatherData()
            _uiState.value = _uiState.value.copy(isLoading = false, weatherData = data, error = null)
        } catch (e: Exception) {
            _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
            e.printStackTrace()
        }
    }
}
