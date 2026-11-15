package com.example.myapplication.model

data class Laporan(
    val id: Int,
    val judul: String,
    val lokasi: String,
    val fotoUrl: String?,
    val status: StatusLaporan = StatusLaporan.Baru
)
