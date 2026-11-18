package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

private data class TabItem(
    val route: String,
    val label: String,
    val icon: String
)

private val daftarTab = listOf(
    TabItem("beranda", "Beranda", "⌂"),
    TabItem("asisten", "Asisten", "✦"),
    TabItem("profil", "Profil", "●")
)

@Composable
fun Handson3BottomNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by
                navController.currentBackStackEntryAsState()

                val currentRoute =
                    navBackStackEntry?.destination?.route

                daftarTab.forEach { tab ->
                    NavigationBarItem(
                        selected = currentRoute == tab.route,
                        onClick = {
                            pindahTabModul5(
                                navController,
                                tab.route
                            )
                        },
                        icon = {
                            Text(tab.icon)
                        },
                        label = {
                            Text(tab.label)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "beranda",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("beranda") {
                HalamanTab(
                    judul = "Beranda",
                    deskripsi = "Ini adalah halaman Beranda."
                )
            }

            composable("asisten") {
                HalamanTab(
                    judul = "Asisten",
                    deskripsi = "Ini adalah halaman Asisten."
                )
            }

            composable("profil") {
                HalamanTab(
                    judul = "Profil",
                    deskripsi = "Ini adalah halaman Profil."
                )
            }
        }
    }
}

private fun pindahTabModul5(
    navController: NavHostController,
    route: String
) {
    navController.navigate(route) {
        popUpTo("beranda") {
            saveState = true
        }

        launchSingleTop = true
        restoreState = true
    }
}

@Composable
private fun HalamanTab(
    judul: String,
    deskripsi: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = judul,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = deskripsi,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
