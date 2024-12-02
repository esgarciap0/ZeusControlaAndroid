package com.example.myapplicationzeuscontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationzeuscontrol.ui.theme.ZeusControlTheme
import androidx.compose.ui.graphics.Color


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZeusControlTheme {
                ZeusControlApp()
            }
        }
    }
}

// Navegación Principal
@Composable
fun ZeusControlApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(onLogin = {
                navController.navigate("dashboard")
            })
        }
        composable("dashboard") {
            DashboardScreen(
                onOrdersClick = { navController.navigate("orders") },
                onInventoryClick = { navController.navigate("inventory") }
            )
        }
        composable("orders") {
            OrdersScreen()
        }
        composable("inventory") {
            InventoryScreen()
        }
    }
}

// Pantalla de Login
@Composable
fun LoginScreen(onLogin: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Zeus Control",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = "", onValueChange = {},
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = "", onValueChange = {},
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onLogin,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            )
        ) {
            Text("Iniciar Sesión")
        }
    }
}

// Pantalla de Dashboard
@Composable
fun DashboardScreen(onOrdersClick: () -> Unit, onInventoryClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Dashboard Zeus Control",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onOrdersClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = Color.White
            )
        ) {
            Text("Órdenes")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onInventoryClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = Color.White
            )
        ) {
            Text("Inventario")
        }
    }
}

// Pantalla de Inventario
@Composable
fun InventoryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Gestión de Inventario",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "ID", modifier = Modifier.weight(1f), color = MaterialTheme.colorScheme.secondary)
            Text(text = "Producto", modifier = Modifier.weight(2f), color = MaterialTheme.colorScheme.secondary)
            Text(text = "Cantidad", modifier = Modifier.weight(1f), color = MaterialTheme.colorScheme.secondary)
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(10) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "PRD-${index + 1}", modifier = Modifier.weight(1f))
                    Text(text = "Lorem Ipsum", modifier = Modifier.weight(2f))
                    Text(text = "${(1..100).random()}", modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

// Pantalla de gestión de órdenes
@Composable
fun OrdersScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Gestión de Órdenes",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "ID", modifier = Modifier.weight(1f), color = MaterialTheme.colorScheme.secondary)
            Text(text = "Cliente", modifier = Modifier.weight(2f), color = MaterialTheme.colorScheme.secondary)
            Text(text = "Estado", modifier = Modifier.weight(1f), color = MaterialTheme.colorScheme.secondary)
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(10) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "ORD-${index + 1}", modifier = Modifier.weight(1f))
                    Text(text = "Lorem Ipsum", modifier = Modifier.weight(2f))
                    Text(text = if (index % 2 == 0) "Completado" else "Pendiente", modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ZeusControlTheme {
        LoginScreen(onLogin = {})
    }
}




