package com.example.greenai.screens

import androidx.navigation3.runtime.NavKey
import com.example.greenai.api.ApiModel

sealed class Screens: NavKey {

    data object LoginScreen: Screens()

    data object HomeScreen: Screens()

    data class ZoneOverview(val nodeParameters: ApiModel): Screens()

    data object SettingsScreen: Screens()

    data object AboutUsScreen: Screens()

    data object AboutProjectScreen: Screens()
}