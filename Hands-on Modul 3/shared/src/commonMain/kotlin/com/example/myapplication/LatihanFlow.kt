
package com.example.myapplication

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

fun aliranSuhu(): Flow<String> {
    val daftarSuhu = listOf(28, 30, 32, 35, 38)

    return daftarSuhu.asFlow()
        .filter { suhu -> suhu > 30 }
        .map { suhu ->
            "Peringatan! Suhu mencapai $suhu°C"
        }
}
