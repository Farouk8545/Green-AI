package com.example.greenai.api.models

import com.example.greenai.api.ApiModel

data class ApiResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ApiModel>
)
