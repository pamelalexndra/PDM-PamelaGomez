package com.example.pagtuno

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun layout() {
    var nombreIngresado: String by remember { mutableStateOf("") }
    val listaNombres: SnapshotStateList<String> = remember { mutableStateListOf() }

    Column(modifier = Modifier.fillMaxSize()) {

        TextField(
            value = nombreIngresado,
            onValueChange = { nuevaEntrada: String -> nombreIngresado = nuevaEntrada },
            placeholder = { Text("Nombre") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    if (nombreIngresado.isNotBlank()) {  // ✅ Validación
                        listaNombres.add(nombreIngresado)
                        nombreIngresado = ""             // ✅ Limpia el campo
                    }
                }
            ) {
                Text("Guardar")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween  // ✅ Espaciado
        ) {
            Text(text = "Listado de nombres y posición en la lista")
            Button(onClick = { listaNombres.clear() }) {
                Text("Limpiar")
            }
        }

        LazyColumn {
            itemsIndexed(listaNombres.toList()) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = item)
                    Text(text = (index + 1).toString())
                }
            }
        }
    }
}