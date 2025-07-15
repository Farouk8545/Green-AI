package com.example.greenai.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greenai.R
import com.example.greenai.ui.theme.AppThemeGreen

@Composable
fun AboutUsScreen(){
    Scaffold(
        topBar = {
            TopBar("About Us")
        }
    ) { padding ->
        Column (
            modifier = Modifier.fillMaxSize()
                .padding(
                    top = padding.calculateTopPadding() + 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = padding.calculateBottomPadding() + 16.dp
                )
                .verticalScroll(rememberScrollState())
        ){
            Box (
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .border(2.dp, AppThemeGreen, RoundedCornerShape(8.dp))
            ){
                Image(
                    painter = painterResource(R.drawable.green_ai_team),
                    contentDescription = "Green AI Team",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.clip(RoundedCornerShape(8.dp))
                )
            }

            Spacer(Modifier.size(16.dp))

            Text(
                text = "About the Team",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.size(24.dp))

            Text(
                text = "we a passionate engineering students who collaborated to make Smart irrigation system and Identifying  and detect tomato plant diseases for our graduation project.\n" +
                        "Each member took on a specialized role to bring the system to life:\n" +
                        "\n" +
                        "mohammed mustafa : responsible for embedded systems and sensor integration.\n" +
                        "\n" +
                        "Amira Gamal and Aml Gamal : responsible for the AI module for plant health analysis using aerial images captured by drones, enabling early disease detection and smart decision-making.\n" +
                        "\n" +
                        " mohammed Gomaa : responsible forserver deployment and ensured reliable data communication.\n" +
                        "\n" +
                        "Amall Fathey :responsible for designing and developing the backend system .\n" +
                        "\n" +
                        "mohammed tarek :responsible for the development of the mobile application for real-time monitoring.\n" +
                        "\n" +
                        "Our team's hard work and technical collaboration earned us 3rd place in the Control Systems Competition held at our college.",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                fontSize = 20.sp
            )
        }
    }
}