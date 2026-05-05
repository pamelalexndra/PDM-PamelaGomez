package com.pdm0126.labo3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Purple    = Color(0xFF7B2FBE)
val TextMain  = Color(0xFF1A1A1A)
val LineColor = Color(0xFFEDE0FA)

@Composable
fun NameScreen(
    onBack: () -> Unit,
) {
    var nombre by remember { mutableStateOf("") }
    val listaNombres: SnapshotStateList<String> = remember { mutableStateListOf() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 28.dp, vertical = 48.dp)
    ) {

        Text(
            text = "Nombres",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = TextMain
        )
        Text(
            text = "${listaNombres.size} nombres",
            fontSize = 13.sp,
            color = Purple,
            modifier = Modifier.padding(top = 2.dp, bottom = 28.dp)
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            placeholder = { Text("Escribe un nombre") },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Purple,
                unfocusedBorderColor = LineColor,
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    if (nombre.isNotBlank()) {
                        listaNombres.add(nombre.trim())
                        nombre = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Purple),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text("Guardar", color = Color.White)
            }

            if (listaNombres.isNotEmpty()) {
                OutlinedButton(
                    onClick = { listaNombres.clear() },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Purple),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Limpiar")
                }
            }
        }

        Spacer(modifier = Modifier.height(28.dp))
        HorizontalDivider(color = LineColor)
        Spacer(modifier = Modifier.height(16.dp))

        if (listaNombres.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxWidth().padding(top = 48.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Sin nombres aún",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                    )
                }
            }
        }

        LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            itemsIndexed(listaNombres.toList()) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item,
                        fontSize = 15.sp,
                        color = TextMain,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "${index + 1}",
                        fontSize = 13.sp,
                        color = Purple,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}