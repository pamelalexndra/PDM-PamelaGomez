package com.pdm0126.labo3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.labo3.ui.screens.HomeScreen
import com.pdm0126.labo3.ui.screens.NameScreen
import com.pdm0126.labo3.ui.screens.SensorScreen

@Composable
fun MainNavigation() {
    var backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                HomeScreen(
                    onNavigateToNombres = { backStack.add(Routes.Nombres) },
                    onNavigateToSensores = { backStack.add(Routes.Sensores) }
                )
            }
            entry<Routes.Nombres> {
                NameScreen(
                    onBack = { backStack.removeLastOrNull()}
                )
            }
            entry<Routes.Sensores> {
                SensorScreen(
                    onBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}