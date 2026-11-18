package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.savedstate.read

data class Item(
    val id: Int,
    val nama: String,
    val deskripsi: String
)

private val daftarItem = listOf(
    Item(1, "Laptop", "Perangkat untuk bekerja dan belajar"),
    Item(2, "Smartphone", "Perangkat komunikasi dan hiburan"),
    Item(3, "Tablet", "Perangkat untuk membaca dan mencatat")
)

@Composable
fun Handson2PassingData() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "daftar"
    ) {
        composable("daftar") {
            DaftarItemScreen(
                items = daftarItem,
                bukaDetail = { itemId ->
                    navController.navigate("detail/$itemId")
                }
            )
        }

        composable(
            route = "detail/{itemId}",
            arguments = listOf(
                navArgument("itemId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val itemId = backStackEntry.arguments?.read {
                getInt("itemId")
            } ?: -1

            DetailItemScreen(
                itemId = itemId,
                kembali = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun DaftarItemScreen(
    items: List<Item>,
    bukaDetail: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Daftar Item",
            style = MaterialTheme.typography.headlineMedium
        )

        items.forEach { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        bukaDetail(item.id)
                    }
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = item.nama,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(text = item.deskripsi)
                    Text(text = "ID: ${item.id}")
                }
            }
        }
    }
}

@Composable
fun DetailItemScreen(
    itemId: Int,
    kembali: () -> Unit
) {
    val item = daftarItem.find { it.id == itemId }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Detail Item",
            style = MaterialTheme.typography.headlineMedium
        )

        if (item != null) {
            Text("ID: ${item.id}")
            Text("Nama: ${item.nama}")
            Text("Deskripsi: ${item.deskripsi}")
        } else {
            Text("Item tidak ditemukan")
        }

        Button(onClick = kembali) {
            Text("Kembali")
        }
    }
}
