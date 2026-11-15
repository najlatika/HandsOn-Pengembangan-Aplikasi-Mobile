package com.example.myapplication.data

import com.example.myapplication.model.Laporan
import com.example.myapplication.model.StatusLaporan
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

suspend fun ambilLaporan(id: Int): Laporan {
    delay(1000)
    return Laporan(
        id,
        "Proyektor mati",
        "GKU 1 R201",
        null
    )
}

suspend fun ambilRiwayat(id: Int): List<String> {
    delay(800)
    return listOf(
        "Dikirim 08.10",
        "Diterima 08.40"
    )
}

fun pantauStatus(id: Int): Flow<StatusLaporan> = flow {
    emit(StatusLaporan.Baru)

    delay(1500)
    emit(StatusLaporan.Diproses("Pak Joko"))

    delay(2000)
    emit(StatusLaporan.Selesai("Lampu proyektor diganti"))
}