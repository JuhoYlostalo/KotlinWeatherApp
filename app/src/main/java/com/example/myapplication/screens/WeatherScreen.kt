package com.example.myapplication.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.components.WeatherCard
import com.example.myapplication.viewmodels.WeatherViewModel

@Composable
fun WeatherScreen(modifier: Modifier = Modifier, viewModel: WeatherViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold { innerPadding ->
        WeatherCard(
            weather = uiState,
            modifier = modifier.padding(innerPadding)
        )
    }
}