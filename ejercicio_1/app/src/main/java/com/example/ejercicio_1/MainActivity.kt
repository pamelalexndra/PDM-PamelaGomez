package com.example.ejercicio_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.ejercicio_1.ui.theme.Ejercicio_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val programas = listOf("Notion 2026", "Facebook 2024", "Spotify 2025")
        val compu = Computadora(
            ram = 16,
            almacenamiento = 256,
            sistemaOperativo = "Windows",
            programasInstalados = programas
        )

        enableEdgeToEdge()
        setContent {
            Ejercicio_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComputadoraScreen(
                        compu = compu,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComputadoraScreen(compu: Computadora, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("--- Datos iniciales ---", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("RAM: ${compu.ram} GB")
        Text("Almacenamiento: ${compu.almacenamiento} GB")
        Text("Sistema Operativo: ${compu.sistemaOperativo}")
        Text("Programas del 2026: ${compu.obtenerProgramas()}")

        Spacer(modifier = Modifier.height(16.dp))

        // Actualizamos y mostramos los nuevos datos
        Text("--- Después de actualizar ---", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        compu.actualizar(nuevaRam = 32, nuevoAlma = 512, nuevoSo = "Ubuntu")
        Text("Nueva RAM: ${compu.ram} GB")
        Text("Nuevo Almacenamiento: ${compu.almacenamiento} GB")
        Text("Nuevo SO: ${compu.sistemaOperativo}")
    }
}