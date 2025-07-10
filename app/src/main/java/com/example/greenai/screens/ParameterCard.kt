package com.example.greenai.screens

import androidx.compose.foundation.background
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
import com.example.greenai.ui.theme.Blue
import com.example.greenai.ui.theme.LightGreen
import com.example.greenai.ui.theme.Red
import com.example.greenai.ui.theme.Yellow

@Composable
fun ParameterCard(parameter: Any, parameterName: String){
    val numericValue = when(parameter){
        is Float -> parameter.toInt()
        else -> parameter
    }
    val value = when(parameterName){
        "Temp (Area)" -> "$parameter °C"
        "Humidity (Area)" -> "$parameter %"
        "Temp (Soil)" -> "$parameter °C"
        "Humidity (Soil)" -> "$parameter %"
        "Soil Moisture" -> "$parameter %"
        "Rain" -> "$parameter mm"
        "Pressure (Kpa)" -> "$parameter kpa"
        "Status" -> if(parameter == 1) "On" else "Off"
        else -> parameter.toString()
    }
    val icon = when(parameterName){
        "Temp (Area)" -> painterResource(R.drawable.thermometer)
        "Humidity (Area)" -> painterResource(R.drawable.water_droplet)
        "Temp (Soil)" -> painterResource(R.drawable.thermometer)
        "Humidity (Soil)" -> painterResource(R.drawable.water_droplet)
        "Soil Moisture" -> painterResource(R.drawable.water_droplet)
        "Rain" -> painterResource(R.drawable.water_droplet)
        "Pressure (Kpa)" -> painterResource(R.drawable.gauge)
        "Status" -> painterResource(R.drawable.onoff)
        else -> painterResource(R.drawable.water_droplet)
    }
    val backgroundColor = if(numericValue in 0..60) Blue
    else if(numericValue in 60..70) LightGreen
    else if(numericValue in 70..80) Yellow
    else Red
    Card (
        modifier = Modifier.background(backgroundColor, RoundedCornerShape(16.dp)),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
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
                    painter = icon,
                    contentDescription = parameterName,
                    tint = Color.Black,
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = parameterName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = value,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}