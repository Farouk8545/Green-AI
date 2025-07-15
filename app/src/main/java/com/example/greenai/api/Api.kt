package com.example.greenai.api

import com.example.greenai.api.models.LoginRequest
import com.example.greenai.api.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @GET("api/testone-by-user")
    suspend fun getGreenHouseParameters(@Query("username") username: String): Response<List<ApiModel>>

    @POST("login/")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

}