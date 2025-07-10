package com.example.greenai.api.repository

import com.example.greenai.api.ApiModel
import com.example.greenai.api.RetrofitInstance
import com.example.greenai.api.models.ApiResponse
import com.example.greenai.api.models.LoginRequest
import com.example.greenai.api.models.LoginResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class ApiRepository @Inject constructor() {
    suspend fun getGreenHouseParameters(username: String): Response<List<ApiModel>> {
        return RetrofitInstance.api.getGreenHouseParameters(username)
    }

    suspend fun login(request: LoginRequest): Response<LoginResponse>{
        return RetrofitInstance.api.login(request)
    }
}