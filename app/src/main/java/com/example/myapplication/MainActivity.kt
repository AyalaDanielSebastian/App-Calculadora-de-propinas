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