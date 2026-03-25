package com.example.pagtuno

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
val PurpleBg  = Color(0xFFF5EEFF)
val TextMain  = Color(0xFF1A1A1A)
val TextSoft  = Color(0xFF9CA3AF)
val LineColor = Color(0xFFEDE0FA)

@Composable
fun layout() {
    var nombreIngresado by remember { mutableStateOf("") }
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
            text = "${listaNombres.size} guardados",
            fontSize = 13.sp,
            color = Purple,
            modifier = Modifier.padding(top = 2.dp, bottom = 28.dp)
        )

        OutlinedTextField(
            value = nombreIngresado,
            onValueChange = { nombreIngresado = it },
            placeholder = { Text("Escribe un nombre", color = TextSoft) },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Purple,
                unfocusedBorderColor = LineColor,
                cursorColor = Purple
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
                    if (nombreIngresado.isNotBlank()) {
                        listaNombres.add(nombreIngresado.trim())
                        nombreIngresado = ""
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
                    border = ButtonDefaults.outlinedButtonBorder.copy(),
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
                    Text(text = "—", fontSize = 32.sp, color = LineColor)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Sin nombres aún",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextSoft
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
                HorizontalDivider(color = LineColor, thickness = 0.5.dp)
            }
        }
    }
}