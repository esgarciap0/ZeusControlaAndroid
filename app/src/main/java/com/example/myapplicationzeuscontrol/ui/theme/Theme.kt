package com.example.myapplicationzeuscontrol.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Esquema de colores básico
private val LightColors = lightColorScheme(
    primary = Color(0xFF6200EA),
    onPrimary = Color.White,
    secondary = Color(0xFF03DAC5),
    onSecondary = Color.White,
    background = Color(0xFFF2F2F2),
    surface = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

// Tema simplificado para pruebas
@Composable
fun ZeusControlTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = MaterialTheme.typography, // Usando typography del MaterialTheme
        content = content
    )
}

