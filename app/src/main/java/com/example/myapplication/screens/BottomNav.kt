package com.example.myapplication.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.appbars.BottomBar
import com.example.myapplication.appbars.TopBar

@Composable
fun BottomNavBar() {
    val navController = rememberNavController()

    val homeRoute = stringResource(R.string.home)
    val infoRoute = stringResource(R.string.info2)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        NavHost(
            navController = navController,
            startDestination = homeRoute,
        ) {
            composable(route = homeRoute) {
                WeatherScreen(modifier = modifier)
            }
            composable(route = infoRoute) {
                InfoScreen(modifier = modifier)
            }
        }
    }
}
