package com.example.aidar_badirov_hw_5_3.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResultResponse(
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String
) : Serializable