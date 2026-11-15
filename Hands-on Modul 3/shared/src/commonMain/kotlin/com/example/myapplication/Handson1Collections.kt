
package com.example.myapplication

data class CollectionProduct(
    val name: String,
    val price: Int
)

fun handson1Collections() {
    val products = listOf(
        CollectionProduct("Laptop", 8500000),
        CollectionProduct("Smartphone", 3500000),
        CollectionProduct("Headphone", 750000),
        CollectionProduct("Keyboard", 450000),
        CollectionProduct("Mouse", 150000),
        CollectionProduct("Monitor", 2200000)
    )

    val batasHarga = 500000

    val hasil = products
        .filter { it.price > batasHarga }
        .sortedBy { it.price }
        .map { it.name }

    println("Produk dengan harga di atas Rp$batasHarga:")
    hasil.forEach { nama ->
        println(nama)
    }
}
