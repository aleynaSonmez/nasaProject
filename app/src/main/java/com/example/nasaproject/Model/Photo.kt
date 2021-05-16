package com.example.nasaproject.Model


import com.google.gson.annotations.SerializedName

data class Photo(
    val camera: Camera,
    @SerializedName("earth_date")
    val earthDate: String,
    val id: Int,
    @SerializedName("img_src")
    var imgSrc: String,
    val rover: Rover,
    val sol: Int,
)