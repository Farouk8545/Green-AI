package com.example.greenai.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.greenai.screens.AboutProjectScreen
import com.example.greenai.screens.AboutUsScreen
import com.example.greenai.screens.HomeScreen
import com.example.greenai.screens.LoginScreen
import com.example.greenai.screens.Screens
import com.example.greenai.screens.SettingsScreen
import com.example.greenai.screens.ZoneOverview

@Composable
fun MainNavigation(){
    val viewModel: MainNavigationViewModel = viewModel()
    var backStack = viewModel.backStack
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider{
            entry<Screens.LoginScreen> {
                LoginScreen()
            }
            entry<Screens.HomeScreen> {
                HomeScreen()
            }
            entry<Screens.ZoneOverview> {
                ZoneOverview(it.nodeParameters)
            }
            entry <Screens.SettingsScreen>{
                SettingsScreen()
            }
            entry <Screens.AboutUsScreen>{
                AboutUsScreen()
            }
            entry <Screens.AboutProjectScreen>{
                AboutProjectScreen()
            }
        }
    )
}