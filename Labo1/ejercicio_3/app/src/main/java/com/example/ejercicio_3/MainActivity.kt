package com.example.ejercicio_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicio_3.ui.theme.Ejercicio_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ciclo01 = listOf(
            Estudiante(nombre = "Andrea Ruiz", carnet = "AR23001", asignatura = "Programación de Dispositivos Móviles"),
            Estudiante(nombre = "Diego Morales", carnet = "DM23002", asignatura = "Programación de Dispositivos Móviles"),
            Estudiante(nombre = "Valeria Castro", carnet = "VC23003", asignatura = "Programación de Dispositivos Móviles"),
            Estudiante(nombre = "Fernando López", carnet = "FL23004", asignatura = "Análisis Numérico"),
            Estudiante(nombre = "Camila Herrera", carnet = "CH23005", asignatura = "Análisis Numérico"),
            Estudiante(nombre = "Javier Mendoza", carnet = "JM23006", asignatura = "Análisis Numérico"),
            Estudiante(nombre = "Gabriela Torres", carnet = "GT23007", asignatura = "Análisis Numérico")
        )

        val dispositivosMoviles = ciclo01.filter {
            it.asignatura == "Programación de Dispositivos Móviles"
        }

        enableEdgeToEdge()
        setContent {
            Ejercicio_3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EstudiantesScreen(
                        estudiantes = dispositivosMoviles,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun EstudiantesScreen(estudiantes: List<Estudiante>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            "--- Estudiantes en Dispositivos Móviles ---",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        estudiantes.forEach { estudiante ->
            Text("Nombre: ${estudiante.nombre} | Carnet: ${estudiante.carnet}")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Total: ${estudiantes.size} estudiantes",
            fontWeight = FontWeight.Bold
        )
    }
}