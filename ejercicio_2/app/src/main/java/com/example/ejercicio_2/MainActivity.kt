package com.example.ejercicio_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.Composable
import com.example.ejercicio_2.ui.theme.Ejercicio_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val calc = Calculadora(
            marca = "Texas Instruments",
            anosDeVida = 7,
            precio = 95.99
        )

        enableEdgeToEdge()
        setContent {
            Ejercicio_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculadoraScreen(
                        calc = calc,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CalculadoraScreen(calc: Calculadora, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("--- Calculadora ${calc.marca} ---", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Años de vida: ${calc.anosDeVida}")
        Text("Precio: $${calc.precio}")

        Spacer(modifier = Modifier.height(16.dp))

        Text("--- Operaciones ---", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("10 + 5 = ${calc.sumar(10.0, 5.0)}")
        Text("10 - 5 = ${calc.restar(10.0, 5.0)}")
        Text("10 * 5 = ${calc.multiplicar(10.0, 5.0)}")
        Text("10 / 5 = ${calc.dividir(10.0, 5.0)}")
    }
}