package com.example.greenai.navigation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.greenai.screens.Screens

class MainNavigationViewModel: ViewModel() {
    var backStack = mutableStateListOf<Screens>(Screens.LoginScreen)
}