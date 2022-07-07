package com.example.proguardapplication.model

typealias Data = ArrayList<Response>

data class Response(
    val urls: Urls,
    val description: String?,
    val color: String
)

data class Urls(
    val regular: String,
    val thumb: String
)