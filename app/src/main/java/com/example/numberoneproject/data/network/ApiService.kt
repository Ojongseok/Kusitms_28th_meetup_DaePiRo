package com.example.numberoneproject.data.network

import com.example.numberoneproject.data.model.SampleResponse
import com.example.numberoneproject.data.model.TokenRequest
import com.example.numberoneproject.data.model.TokenResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/api/v1/articles")
    suspend fun getQuestions(): ApiResult<SampleResponse>

    @POST("/token/kakao")
    suspend fun getToken(@Body request: TokenRequest): TokenResponse

}