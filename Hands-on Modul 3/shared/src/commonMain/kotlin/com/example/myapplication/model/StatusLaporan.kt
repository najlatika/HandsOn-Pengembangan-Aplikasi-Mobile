package com.example.myapplication.model

sealed class StatusLaporan {
    data object Baru : StatusLaporan()
    data class Diproses(val petugas: String) : StatusLaporan()
    data class Selesai(val catatan: String) : StatusLaporan()
}
