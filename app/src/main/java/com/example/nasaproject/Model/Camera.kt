package com.example.nasaproject.Model


import com.google.gson.annotations.SerializedName

data class Camera(
    @SerializedName("full_name")
    var fullName: String,
    val id: Int,
    val name: String,
    @SerializedName("rover_id")
    val roverİd: Int
)