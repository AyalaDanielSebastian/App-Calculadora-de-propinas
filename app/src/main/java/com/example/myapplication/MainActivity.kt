package com.example.calculadorapropinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraPropinasApp()
        }
    }
}

@Composable
fun CalculadoraPropinasApp() {
    var monto by remember { mutableStateOf("") }
    var porcentaje by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("Resultado: $0.00") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Calculadora de Propinas")

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = monto,
            onValueChange = { monto = it },
            label = { Text("Monto de la cuenta") }
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = porcentaje,
            onValueChange = { porcentaje = it },
            label = { Text("Porcentaje de propina") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val cuenta = monto.toDoubleOrNull() ?: 0.0
                val propinaPorcentaje = porcentaje.toDoubleOrNull() ?: 0.0
                val propina = cuenta * propinaPorcentaje / 100
                val total = cuenta + propina

                resultado = "Propina: $${"%.2f".format(propina)}\nTotal: $${"%.2f".format(total)}"
            }
        ) {
            Text("Calcular propina")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = resultado)
    }
}