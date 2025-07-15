package com.example.greenai.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.greenai.navigation.MainNavigationViewModel
import com.example.greenai.ui.theme.AppThemeGreen
import com.example.greenai.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String
){
    val navViewModel: MainNavigationViewModel = hiltViewModel()

    TopAppBar(
        title = {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    style = Typography.headlineLarge,
                    color = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppThemeGreen
        ),
        navigationIcon = {
            if (navViewModel.backStack.lastOrNull() !is Screens.HomeScreen){
                IconButton(
                    onClick = {
                        navViewModel.backStack.removeLastOrNull()
                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        },
        actions = {
            if (
                navViewModel.backStack.lastOrNull() !is Screens.SettingsScreen &&
                navViewModel.backStack.lastOrNull() !is Screens.AboutProjectScreen &&
                navViewModel.backStack.lastOrNull() !is Screens.AboutUsScreen
                ){
                IconButton(
                    onClick = {
                        navViewModel.backStack.add(Screens.SettingsScreen)
                    },
                    modifier = Modifier.padding(end = 12.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    )
}