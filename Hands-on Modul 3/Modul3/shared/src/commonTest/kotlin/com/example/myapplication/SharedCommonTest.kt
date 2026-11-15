
package com.example.myapplication

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertEquals

class SharedCommonTest {

    // Pengujian 1: Profil lengkap
    @Test
    fun testProfilLengkap() {
        val hasil = buatProfil(
            nama = "Tika",
            umur = 21,
            hobi = "Membaca"
        )

        assertTrue(hasil.contains("Tika"))
        assertTrue(hasil.contains("21 tahun"))
        assertTrue(hasil.contains("Membaca"))
    }

    // Pengujian 2: Umur bernilai null
    @Test
    fun testUmurNull() {
        val hasil = buatProfil(
            nama = "Tika",
            umur = null
        )

        assertTrue(hasil.contains("Belum diketahui"))
    }

    // Pengujian 3: Menggunakan hobi default
    @Test
    fun testHobiDefault() {
        val hasil = buatProfil(
            nama = "Tika",
            umur = 21
        )

        assertTrue(hasil.contains("Belum diisi"))
    }
    @Test
    fun testKonversiNilai() {
        assertEquals("A", konversiNilai(90))
        assertEquals("B", konversiNilai(80))
        assertEquals("C", konversiNilai(70))
        assertEquals("D", konversiNilai(60))
        assertEquals("E", konversiNilai(40))
        assertEquals("Nilai tidak valid", konversiNilai(110))
    }
}
