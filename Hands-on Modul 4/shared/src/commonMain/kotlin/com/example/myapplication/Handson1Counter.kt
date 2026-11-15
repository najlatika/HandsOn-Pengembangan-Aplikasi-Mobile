
package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Handson1Counter() {
    var angka by remember { mutableIntStateOf(0) }

    Card(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Counter",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = angka.toString(),
                style = MaterialTheme.typography.displayMedium
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { angka-- },
                    enabled = angka > 0
                ) {
                    Text("Kurang")
                }

                Button(
                    onClick = { angka++ }
                ) {
                    Text("Tambah")
                }
            }

            Button(
                onClick = { angka = 0 }
            ) {
                Text("Reset")
            }
        }
    }
}
