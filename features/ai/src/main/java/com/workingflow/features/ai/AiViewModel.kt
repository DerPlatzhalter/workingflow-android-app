package com.workingflow.features.ai

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

data class AiRequest(val question: String)
data class AiResponse(val answer: String)

interface AiApiService {
    @POST("ai/query")
    suspend fun queryAi(
        @Header("Authorization") apiKey: String,
        @Body request: AiRequest
    ): AiResponse
}

class AiViewModel : ViewModel() {

    private val _answer = MutableStateFlow<String?>(null)
    val answer: StateFlow<String?> = _answer

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:3000/") // Replace with actual backend URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(AiApiService::class.java)

    fun sendQuestion(apiKey: String, question: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = apiService.queryAi("Bearer $apiKey", AiRequest(question))
                _answer.value = response.answer
            } catch (e: Exception) {
                _answer.value = "Error: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
