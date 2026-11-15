
package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    var latihanDipilih by remember { mutableIntStateOf(1) }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Latihan Modul 4 - State dan MVVM",
                style = MaterialTheme.typography.headlineSmall
            )

            Button(onClick = { latihanDipilih = 1 }) {
                Text("Latihan 1 - Counter")
            }

            Button(onClick = { latihanDipilih = 2 }) {
                Text("Latihan 2 - Registration Form")
            }

            Button(onClick = { latihanDipilih = 3 }) {
                Text("Latihan 3 - Todo App")
            }

            when (latihanDipilih) {
                1 -> Handson1Counter()
                2 -> Handson2RegistrationForm()
                3 -> Handson3TodoApp()
            }
        }
    }
}
