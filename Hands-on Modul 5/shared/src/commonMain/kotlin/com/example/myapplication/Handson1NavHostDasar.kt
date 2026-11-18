package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Handson1NavHostDasar() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                bukaDetail = {
                    navController.navigate("detail")
                }
            )
        }

        composable("detail") {
            DetailScreen(
                kembali = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun HomeScreen(
    bukaDetail: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Halaman Home",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Selamat datang di halaman utama"
        )

        Button(
            onClick = bukaDetail,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Buka Detail")
        }
    }
}

@Composable
fun DetailScreen(
    kembali: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Halaman Detail",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("Ini adalah halaman detail.")

        Button(
            onClick = kembali,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Kembali ke Home")
        }
    }
}
