
package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    var hasil by remember {
        mutableStateOf("Memeriksa suhu...")
    }

    LaunchedEffect(Unit) {
        val peringatan = mutableListOf<String>()

        aliranSuhu().collect { pesan ->
            peringatan.add(pesan)
            hasil = peringatan.joinToString("\n\n")
        }

        if (peringatan.isEmpty()) {
            hasil = "Tidak ada suhu di atas 30°C"
        }
    }

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Latihan Flow - Pemantauan Suhu",
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = hasil,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
