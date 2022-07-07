package com.example.proguardapplication

import javax.inject.Inject

class Repo @Inject constructor(private val apiService: ApiService) {
    suspend fun getPhotos() = apiService.getPhotos(1, 20)
}