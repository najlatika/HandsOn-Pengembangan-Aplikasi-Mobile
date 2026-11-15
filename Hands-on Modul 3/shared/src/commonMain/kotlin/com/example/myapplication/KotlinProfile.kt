package com.example.myapplication

fun buatProfil(
    nama: String,
    umur: Int?,
    hobi: String = "Belum diisi"
): String {
    val informasiUmur = umur?.let { "$it tahun" } ?: "Belum diketahui"

    return """
        === PROFIL MAHASISWA ===
        Nama : $nama
        Umur : $informasiUmur
        Hobi : $hobi
    """.trimIndent()
}
