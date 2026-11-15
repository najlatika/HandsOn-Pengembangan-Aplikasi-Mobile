
package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private data class ProductItem(
    val name: String,
    val price: String,
    val color: Color
)

@Composable
fun ProductList() {
    val products = listOf(
        ProductItem("Laptop", "Rp8.500.000", Color(0xFFFFB6C1)),
        ProductItem("Smartphone", "Rp4.200.000", Color(0xFFADD8E6)),
        ProductItem("Headphone", "Rp750.000", Color(0xFFFFDAB9)),
        ProductItem("Keyboard", "Rp450.000", Color(0xFFDDA0DD)),
        ProductItem("Mouse", "Rp250.000", Color(0xFF98FB98))
    )

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Daftar Produk",
            style = MaterialTheme.typography.headlineSmall
        )

        products.forEach { product ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    androidx.compose.foundation.layout.Box(
                        modifier = Modifier
                            .size(56.dp)
                            .background(
                                color = product.color,
                                shape = RoundedCornerShape(8.dp)
                            )
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = product.name,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text(
                            text = product.price,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}
