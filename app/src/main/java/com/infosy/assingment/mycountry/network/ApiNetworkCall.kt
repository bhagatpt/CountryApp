package com.infosy.assingment.mycountry.network

import com.infosy.assingment.mycountry.model.Country
import retrofit2.Call
import retrofit2.http.GET

interface ApiNetworkCall {
    @get:GET("/s/2iodh4vg0eortkl/facts.json")
    val countryDetails: Call<Country?>?
}