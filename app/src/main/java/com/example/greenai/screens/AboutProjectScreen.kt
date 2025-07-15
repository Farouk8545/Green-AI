package com.example.greenai.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutProjectScreen(){
    Scaffold (
        topBar = {
            TopBar("About Project")
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
            Text(
                text = "Our project is a smart greenhouse management system that combines Internet of Things (IoT) and Artificial Intelligence (AI) technologies.\n" +
                        "It continuously monitors environmental conditions using sensors, and transmits real-time data via MQTT to a Django-based backend system.\n" +
                        "The project also features drone-based plant image analysis using AI, enabling early detection of plant diseases.\n" +
                        "A mobile application displays live data and insights, helping farmers make informed decisions and optimize agricultural productivity",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                textAlign = TextAlign.Start
            )
        }
    }
}