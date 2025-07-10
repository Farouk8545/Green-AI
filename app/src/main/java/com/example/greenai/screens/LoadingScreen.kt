package com.example.greenai.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.greenai.ui.theme.AppThemeGreen
import com.example.greenai.ui.theme.GrayedTransparent

@Composable
fun LoadingScreen(){
    Box(
        modifier = Modifier.fillMaxSize()
            .background(GrayedTransparent),
        contentAlignment = Alignment.Center
    ) {
        Card (
            modifier = Modifier.size(100.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ){
            Box (
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator(
                    modifier = Modifier.size(64.dp),
                    color = AppThemeGreen,
                    strokeWidth = 5.dp
                )
            }
        }
    }
}