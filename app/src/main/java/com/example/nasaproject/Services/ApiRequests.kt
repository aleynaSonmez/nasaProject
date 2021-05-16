package com.example.nasaproject.Services

import com.example.nasaproject.Model.RoverJson
import io.reactivex.Single
import retrofit2.http.GET

interface ApiRequests {
    //key belkide yenilenerek 429 sorununu çözmüş olurum.
    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=cwjI7xdpnvAqlY728eRcDIwW1FTCJ7loMUWiWpXv") //spirit yerine ne yazarsam o araç geliyor.

    fun getData(): Single<RoverJson>
    @GET("mars-photos/api/v1/rovers/spirit/photos?sol=1000&api_key=cwjI7xdpnvAqlY728eRcDIwW1FTCJ7loMUWiWpXv") //spirit yerine ne yazarsam o araç geliyor.

    fun getDataSpirit(): Single<RoverJson>

    @GET("mars-photos/api/v1/rovers/opportunity/photos?sol=1000&api_key=cwjI7xdpnvAqlY728eRcDIwW1FTCJ7loMUWiWpXv") //spirit yerine ne yazarsam o araç geliyor.

    fun getDataOpportunity(): Single<RoverJson>
}

