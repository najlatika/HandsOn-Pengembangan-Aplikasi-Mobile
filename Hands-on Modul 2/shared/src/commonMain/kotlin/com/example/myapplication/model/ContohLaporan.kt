package com.example.myapplication.model

fun contohLaporan(): String {
    val a = Laporan(7, "Proyektor mati", "GKU 1 R201", null)
    val b = a.copy(
        status = StatusLaporan.Diproses("Pak Joko")
    )

    return """
        ${a == b}
        ${a.status.label()}
        ${b.status.label()}
        ${a.fotoUrl?.length ?: 0}
    """.trimIndent()
}
