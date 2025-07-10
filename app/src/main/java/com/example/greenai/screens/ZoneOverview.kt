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
import com.example.greenai.api.ApiModel

@Composable
fun ZoneOverview(nodeParameters: ApiModel){
    val valuesMap = mapOf<Any, String>(
        nodeParameters.temperature_area to "Temp (Area)",
        nodeParameters.humidity_area to "Humidity (Area)",
        nodeParameters.temperature_soil to "Temp (Soil)",
        nodeParameters.humidity_soil to "Humidity (Soil)",
        nodeParameters.soil to "Soil Moisture",
        nodeParameters.rain to "Rain",
        nodeParameters.pressure_kpa to "Pressure (Kpa)",
        nodeParameters.status to "Status"
    )
    val keys = valuesMap.keys.toList()
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
                items(8) {
                    ParameterCard(keys[it], valuesMap[keys[it]].toString())
                }
            }
        }
    }
}