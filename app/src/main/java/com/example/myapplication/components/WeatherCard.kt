package com.example.myapplication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.viewmodels.WeatherUiState

@Composable
fun WeatherCard(weather: WeatherUiState, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val data = weather.weatherData
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .padding(16.dp)
                .weight(1f)) {

                if (data != null) {
                    Text(
                        text = data.name,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = data.weather.firstOrNull()?.description ?: stringResource(R.string.no_description),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.wind_speed_m_s, data.wind.speed),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.c, data.main.temp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                } else if (weather.isLoading) {
                    Text(text = stringResource(R.string.loading_weather))
                } else if (weather.error != null) {
                    Text(text = stringResource(R.string.error, weather.error))
                } else {
                    Text(text = stringResource(R.string.no_data_available))
                }
            }
            AsyncImage(
                //i could not extract this as a string
                model = "https://openweathermap.org/img/wn/${data?.weather?.firstOrNull()?.icon}@2x.png",
                contentDescription = null,
                modifier = Modifier.height(140.dp)
            )
        }
    }
}
