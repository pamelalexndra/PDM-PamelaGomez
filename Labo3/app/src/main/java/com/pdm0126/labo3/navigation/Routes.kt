package com.pdm0126.labo3.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
sealed class Routes : NavKey {

    @Serializable
    data object Home : Routes()

    @Serializable
    data object Nombres : Routes()

    @Serializable
    data object Sensores : Routes()

}