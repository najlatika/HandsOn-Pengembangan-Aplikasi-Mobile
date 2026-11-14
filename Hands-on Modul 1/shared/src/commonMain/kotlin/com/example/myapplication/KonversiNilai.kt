
package com.example.myapplication

fun konversiNilai(nilai: Int): String {
    return when (nilai) {
        in 85..100 -> "A"
        in 75..84 -> "B"
        in 65..74 -> "C"
        in 50..64 -> "D"
        in 0..49 -> "E"
        else -> "Nilai tidak valid"
    }
}
