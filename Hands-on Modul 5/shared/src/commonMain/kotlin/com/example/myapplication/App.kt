package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    var latihanDipilih by remember {
        mutableIntStateOf(1)
    }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Hands-on Modul 5 - Navigasi Antar Layar",
                style = MaterialTheme.typography.headlineSmall
            )

            Button(
                onClick = { latihanDipilih = 1 },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Latihan 1 - NavHost Dasar")
            }

            Button(
                onClick = { latihanDipilih = 2 },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Latihan 2 - Passing Data")
            }

            Button(
                onClick = { latihanDipilih = 3 },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Latihan 3 - Bottom Navigation")
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                when (latihanDipilih) {
                    1 -> Handson1NavHostDasar()
                    2 -> Handson2PassingData()
                    3 -> Handson3BottomNavigation()
                }
            }
        }
    }
}
