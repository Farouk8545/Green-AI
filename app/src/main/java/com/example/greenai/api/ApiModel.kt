package com.example.greenai.api

data class ApiModel(
    val temperature_area: Float,
    val humidity_area: Float,
    val temperature_soil: Int,
    val humidity_soil: Int,
    val soil: Int,
    val rain: Float,
    val pressure_kpa: Float,
    val node_id: Int,
    val status: Int,
    val greenhouse_id: Int
)
