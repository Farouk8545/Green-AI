package com.example.greenai.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greenai.R
import com.example.greenai.ui.theme.AppThemeGreen
import com.example.greenai.ui.theme.LightGreen

@Composable
fun ZoneCard(
    zoneName: String,
    onClick: () -> Unit
){
    Card (
        modifier = Modifier.background(LightGreen, RoundedCornerShape(16.dp))
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = LightGreen
        )
    ){
        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column (
                modifier = Modifier.padding(16.dp)
            ){
                Icon(
                    painter = painterResource(R.drawable.water_droplet),
                    contentDescription = "Irrigation Zone",
                    tint = AppThemeGreen,
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.size(32.dp))
                Text(
                    text = zoneName,
                    fontSize = 32.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}