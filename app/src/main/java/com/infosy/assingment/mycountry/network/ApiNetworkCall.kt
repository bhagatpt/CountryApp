package com.infosy.assingment.mycountry.network;

import com.infosy.assingment.mycountry.model.Country;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiNetworkCall {

    //country details API
    @GET("/s/2iodh4vg0eortkl/facts.json")
    Call<Country> getCountryDetails();


}
