package com.example.myapplication.coroutines

import kotlinx.coroutines.delay

suspend fun ambilData(): String {
    delay(2000)
    return "Data berhasil diambil!"
}
