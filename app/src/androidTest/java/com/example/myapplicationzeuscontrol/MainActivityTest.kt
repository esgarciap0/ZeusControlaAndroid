package com.example.myapplicationzeuscontrol

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.myapplicationzeuscontrol.ui.theme.ZeusControlTheme
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.onNodeWithText


class MainActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verificarQueBotonDeIniciarSesionSeaClickeable() {
        composeTestRule.setContent {
            ZeusControlTheme {
                LoginScreen(onLogin = {})
            }
        }
        composeTestRule.onNodeWithText("Iniciar Sesión").assertHasClickAction()
    }


    @Test
    fun verificarComponentesDeLoginScreen() {
        composeTestRule.setContent {
            ZeusControlTheme {
                LoginScreen(onLogin = {})
            }
        }

        // Verifica que los campos de texto están presentes
        composeTestRule.onNodeWithText("Usuario").assertExists()
        composeTestRule.onNodeWithText("Contraseña").assertExists()

        // Verifica que el botón está presente y es clickeable
        composeTestRule.onNodeWithText("Iniciar Sesión").assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun verificarNavegacionAlDashboard() {
        composeTestRule.setContent {
            ZeusControlTheme {
                ZeusControlApp()
            }
        }

        // Simula clic en el botón de iniciar sesión
        composeTestRule.onNodeWithText("Iniciar Sesión").performClick()

        // Verifica que el texto del Dashboard está visible
        composeTestRule.onNodeWithText("Dashboard Zeus Control").assertExists()
    }
}


