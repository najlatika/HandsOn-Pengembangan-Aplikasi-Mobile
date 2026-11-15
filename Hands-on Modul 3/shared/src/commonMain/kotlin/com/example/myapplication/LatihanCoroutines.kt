
package com.example.myapplication

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlin.system.measureTimeMillis

data class HasilLatihan(
    val profil: String,
    val postingan: List<String>,
    val waktu: Long
)

suspend fun ambilProfilDanPostingan(): HasilLatihan {
    lateinit var profil: String
    lateinit var postingan: List<String>

    val waktu = measureTimeMillis {
        coroutineScope {
            val dataProfil = async {
                delay(1000)
                "Nama: Tika\nProgram Studi: Teknik Informatika"
            }

            val dataPostingan = async {
                delay(800)
                listOf(
                    "Belajar Kotlin",
                    "Belajar Coroutines",
                    "Belajar Flow"
                )
            }

            profil = dataProfil.await()
            postingan = dataPostingan.await()
        }
    }

    return HasilLatihan(profil, postingan, waktu)
}
