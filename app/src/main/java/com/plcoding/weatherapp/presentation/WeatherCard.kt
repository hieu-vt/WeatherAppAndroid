package com.plcoding.weatherapp.presentation

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.time.format.DateTimeFormatter

@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: androidx.compose.ui.Modifier
){
    state.weatherInfo?.currentWeatherData?.let {data ->
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column (
                modifier = modifier.fillMaxWidth().padding(16.dp)
            ){
                Text(
                    text = "Today ${data.time.format(DateTimeFormatter.ofPattern("HH:mm"))}"
                )
            }
        }
    }

}