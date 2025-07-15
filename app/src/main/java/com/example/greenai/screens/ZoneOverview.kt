package com.example.greenai.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.greenai.api.ApiModel
import com.example.greenai.navigation.MainNavigationViewModel

@Composable
fun ZoneOverview(nodeParameters: ApiModel){

    val valuesMap = mapOf<String, Any>(
        "Temp (Area)" to nodeParameters.temperature_area,
        "Humidity (Area)" to nodeParameters.humidity_area,
        "Temp (Soil)" to nodeParameters.temperature_soil,
        "Humidity (Soil)" to nodeParameters.humidity_soil,
        "Soil Moisture" to nodeParameters.soil,
        "Rain" to nodeParameters.rain,
        "Pressure (Kpa)" to nodeParameters.pressure_kpa,
        "Status" to nodeParameters.status
    )

    val keys = valuesMap.keys.toList()
    println(keys[2])
    println(valuesMap[keys[2]].toString())
    Scaffold(
        topBar = {
            TopBar("Zone ${nodeParameters.node_id} Overview")
        }
    ) { padding ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(padding)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                state = rememberLazyGridState(),
                contentPadding = PaddingValues(32.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(keys.size) {
                    ParameterCard(keys[it], valuesMap[keys[it]].toString())
                }
            }
        }
    }
}