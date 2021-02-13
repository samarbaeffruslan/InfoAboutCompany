package com.example.core_api.dto

import com.google.gson.annotations.SerializedName

data class CompanyDTO(
    @SerializedName("id")
    val id: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String
)