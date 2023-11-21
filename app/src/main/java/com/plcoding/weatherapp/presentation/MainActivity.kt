package com.plcoding.weatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.plcoding.weatherapp.presentation.ui.theme.DarkBlue
import com.plcoding.weatherapp.presentation.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
//        permissionLauncher = registerForActivityResult(
//            ActivityResultContracts.RequestMultiplePermissions()
//        ) {
//            viewModel.loadWeatherInfo()
//        }
//        permissionLauncher.launch(arrayOf(
//            Manifest.permission.ACCESS_FINE_LOCATION,
//            Manifest.permission.ACCESS_COARSE_LOCATION,
//        ))
        setContent {
            val interactionSource = remember { MutableInteractionSource() }

            WeatherAppTheme {
                Box (
                    modifier = Modifier.fillMaxSize()
                ) {
                       Column(
                           modifier = Modifier.fillMaxSize().background(DarkBlue)
                       ){
                           Text("Hello teacher", modifier = Modifier.align(Alignment.End), color = Color.White )
                           Spacer(modifier = Modifier.height(16.dp))
                           Column (modifier = Modifier
                               .size(width = 200.dp, height = 50.dp)
                               .align(Alignment.CenterHorizontally)
                               .border(width = 2.dp, color = Color.Yellow, shape = RoundedCornerShape(50.dp)))
                           {
                               Text("Button", modifier = Modifier.align(Alignment.End), color = Color.White )
                           }
                           Button(
                               onClick = {},
                               modifier = Modifier
                                   .padding(16.dp)
                                   .background(color = Color.Green, shape = RoundedCornerShape(32.dp))
                                   .height(50.dp)
                                   .padding(horizontal = 20.dp)
                               ,
                               colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                               interactionSource = interactionSource,
                               elevation = ButtonDefaults.elevation(
                                   defaultElevation = 4.dp,
                                   pressedElevation = 0.dp
                               )
                           ){
                               Text("Login", color = Color.White)
                           }
                       }
                }
            }
        }
    }

}

