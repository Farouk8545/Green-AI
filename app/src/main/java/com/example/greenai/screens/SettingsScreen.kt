package com.example.greenai.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.greenai.R
import com.example.greenai.api.viewmodel.ApiViewModel
import com.example.greenai.navigation.MainNavigationViewModel
import com.example.greenai.ui.theme.AppThemeGreen

@Composable
fun SettingsScreen(){
    val apiViewModel: ApiViewModel = hiltViewModel()
    val navViewModel: MainNavigationViewModel = hiltViewModel()

    Scaffold (
        topBar = {
            TopBar("Settings")
        }
    ){ padding ->
        Box (
            modifier = Modifier.fillMaxSize()
                .padding(padding)
        ){
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(16.dp)
            ) {
                Spacer(Modifier.size(32.dp))

                Image(
                    painter = painterResource(R.drawable.place_holder),
                    contentDescription = "Profile picture",
                    modifier = Modifier.size(96.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(Modifier.size(8.dp))

                Text(
                    text = apiViewModel.loggedInUser.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(Modifier.size(48.dp))

                Button(
                    modifier = Modifier.width(300.dp)
                        .padding(bottom = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .align(Alignment.CenterHorizontally),
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppThemeGreen,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Change Password",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }

                Button(
                    modifier = Modifier.width(300.dp)
                        .padding(bottom = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .align(Alignment.CenterHorizontally),
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppThemeGreen,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Language",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }

                Button(
                    modifier = Modifier.width(300.dp)
                        .padding(bottom = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .align(Alignment.CenterHorizontally),
                    onClick = {
                        navViewModel.backStack.add(Screens.AboutProjectScreen)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppThemeGreen,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "About Project",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }

                Button(
                    modifier = Modifier.width(300.dp)
                        .padding(bottom = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .align(Alignment.CenterHorizontally),
                    onClick = {
                        navViewModel.backStack.add(Screens.AboutUsScreen)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppThemeGreen,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "About Us",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }

                Button(
                    modifier = Modifier.width(300.dp)
                        .padding(bottom = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .align(Alignment.CenterHorizontally),
                    onClick = {
                        apiViewModel.logout()
                        navViewModel.backStack.clear()
                        navViewModel.backStack.add(Screens.LoginScreen)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppThemeGreen,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Logout",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}