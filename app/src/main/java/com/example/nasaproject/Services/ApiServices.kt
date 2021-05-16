package com.example.nasaproject.Services

import com.example.nasaproject.Model.RoverJson
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiServices {
    private val BASE_URL = "https://api.nasa.gov/"
    val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiRequests::class.java)

    fun getDataServices(): Single<RoverJson> {
        return api.getData()

    }
    fun getDataServicesS(): Single<RoverJson> {
        return api.getDataSpirit()

    }
    fun getDataServicesO(): Single<RoverJson> {
        return api.getDataOpportunity()

    }
}