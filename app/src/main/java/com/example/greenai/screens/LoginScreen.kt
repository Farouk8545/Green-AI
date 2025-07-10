package com.example.greenai.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.greenai.R
import com.example.greenai.api.models.LoginRequest
import com.example.greenai.api.viewmodel.ApiViewModel
import com.example.greenai.navigation.MainNavigationViewModel
import com.example.greenai.ui.theme.AppThemeGreen
import com.example.greenai.ui.theme.Typography

@Composable
fun LoginScreen(){
    var usernameText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    val context = LocalContext.current
    val viewModel: ApiViewModel = hiltViewModel()
    var navViewModel: MainNavigationViewModel = viewModel()
    if(viewModel.loggedInUser != null){
        navViewModel.backStack.clear()
        navViewModel.backStack.add(Screens.HomeScreen)
    }else if (viewModel.errorMessage != null){
        Toast.makeText(context, viewModel.errorMessage, Toast.LENGTH_SHORT).show()
        viewModel.errorMessage = null
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.green_ai_login_background),
                contentScale = ContentScale.FillBounds
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Login",
                style = Typography.headlineLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.size(100.dp))

            OutlinedTextField(
                value = usernameText,
                onValueChange = { usernameText = it },
                placeholder = { Text(text = "Username") },
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Email") },
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = AppThemeGreen
                )
            )

            Spacer(modifier = Modifier.size(24.dp))

            OutlinedTextField(
                value = passwordText,
                onValueChange = { passwordText = it },
                placeholder = { Text(text = "Password") },
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Email") },
                modifier = Modifier.fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = AppThemeGreen
                ),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.size(24.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonColors(
                    containerColor = AppThemeGreen,
                    contentColor = Color.White,
                    disabledContainerColor = AppThemeGreen,
                    disabledContentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    if(usernameText.isNotEmpty() && passwordText.isNotEmpty()){
                        viewModel.login(LoginRequest(usernameText, passwordText))
                    }else{
                        Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                    }
                }
            ) {
                Text(
                    text = "Login",
                    style = Typography.bodyLarge,
                )
            }
        }
    }
    if(viewModel.isLoading){
        LoadingScreen()
    }
}