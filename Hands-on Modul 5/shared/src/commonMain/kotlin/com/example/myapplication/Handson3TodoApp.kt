
package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class TodoItem(
    val id: Int,
    val judul: String,
    val selesai: Boolean = false
)

data class TodoUiState(
    val daftarTodo: List<TodoItem> = emptyList()
)

class TodoViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TodoUiState())
    val uiState = _uiState.asStateFlow()

    private var nextId = 1

    fun tambahTodo(judul: String) {
        if (judul.isBlank()) return

        val todoBaru = TodoItem(
            id = nextId++,
            judul = judul
        )

        _uiState.update { state ->
            state.copy(
                daftarTodo = state.daftarTodo + todoBaru
            )
        }
    }

    fun ubahStatus(id: Int) {
        _uiState.update { state ->
            state.copy(
                daftarTodo = state.daftarTodo.map { todo ->
                    if (todo.id == id) {
                        todo.copy(selesai = !todo.selesai)
                    } else {
                        todo
                    }
                }
            )
        }
    }
}

@Composable
fun Handson3TodoApp(
    vm: TodoViewModel = viewModel { TodoViewModel() }
) {
    val state by vm.uiState.collectAsState()
    var inputTodo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Todo App",
            style = MaterialTheme.typography.headlineSmall
        )

        OutlinedTextField(
            value = inputTodo,
            onValueChange = { inputTodo = it },
            label = { Text("Masukkan kegiatan") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                vm.tambahTodo(inputTodo)
                inputTodo = ""
            },
            enabled = inputTodo.isNotBlank()
        ) {
            Text("Tambah Todo")
        }

        Text(
            text = "Daftar Kegiatan",
            style = MaterialTheme.typography.titleMedium
        )

        state.daftarTodo.forEach { todo ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = todo.selesai,
                        onCheckedChange = {
                            vm.ubahStatus(todo.id)
                        }
                    )

                    Text(
                        text = if (todo.selesai) {
                            "${todo.judul} (Selesai)"
                        } else {
                            todo.judul
                        }
                    )
                }
            }
        }
    }
}
