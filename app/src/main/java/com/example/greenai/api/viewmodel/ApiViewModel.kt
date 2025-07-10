package com.example.greenai.api.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.greenai.api.ApiModel
import com.example.greenai.api.models.LoginRequest
import com.example.greenai.api.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ApiViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {
    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)

    var loggedInUser by mutableStateOf<String?>(null)
        private set

    var greenHouseParameters by mutableStateOf<List<ApiModel>?>(emptyList())
        private set

    private fun getGreenHouseParameters(greenHouse: String){
        viewModelScope.launch {
            isLoading = true
            try {
                val response = repository.getGreenHouseParameters(greenHouse)
                if (response.isSuccessful){
                    greenHouseParameters = response.body() ?: emptyList()
                }else{
                    errorMessage = response.message()
                }
            }catch (e: IOException){
                errorMessage = e.message
            }catch (e: Exception){
                errorMessage = e.message
            }finally {
                isLoading = false
            }
        }
    }

    fun login(request: LoginRequest) {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = repository.login(request)

                if (response.isSuccessful) {
                    loggedInUser = request.username
                    getGreenHouseParameters(loggedInUser.toString())
                } else {
                    errorMessage = when (response.code()) {
                        401 -> "Invalid username or password"
                        else -> "Error: ${response.code()}"
                    }
                    isLoading = false
                }
            } catch (e: IOException) {
                errorMessage = "Network error: ${e.message ?: "Unknown error"}"
                isLoading = false
            } catch (e: Exception) {
                errorMessage = "Unexpected error: ${e.message ?: "Unknown error"}"
                isLoading = false
            }
        }
    }

}