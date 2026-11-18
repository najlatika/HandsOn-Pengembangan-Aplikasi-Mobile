package com.example.myapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

fun sapaanPlatform(): String {
    return "Halo! Aplikasi berjalan di ${getPlatform().name}"
}
