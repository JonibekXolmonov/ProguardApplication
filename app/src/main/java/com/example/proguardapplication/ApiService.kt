package com.example.proguardapplication

import com.example.proguardapplication.model.Data
import com.example.proguardapplication.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("photos?")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Data
}