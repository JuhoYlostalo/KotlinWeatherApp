package com.example.myapplication.appbars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.R

@Composable
fun BottomBar(navController: NavController){
    val backStackEntry = navController.currentBackStackEntryAsState()

    val tabs = listOf(
        TabItem(stringResource(R.string.weather), Icons.Filled.Home, stringResource(R.string.home)),
        TabItem(stringResource(R.string.info), Icons.Filled.Info, stringResource(R.string.info2))
    )

    NavigationBar {
        tabs.forEach { tab ->
            val selected = tab.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(tab.route) },
                label = { Text(tab.label) },
                icon = {
                    Icon(
                        imageVector = tab.icon,
                        contentDescription = tab.label
                    )
                }
            )
        }
    }
}