package com.infosy.assingment.mycountry.repository;



import android.app.ProgressDialog;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.infosy.assingment.mycountry.model.Country;
import com.infosy.assingment.mycountry.model.CountryDetails;
import com.infosy.assingment.mycountry.network.ApiClient;
import com.infosy.assingment.mycountry.network.ApiNetworkCall;

import java.util.ConcurrentModificationException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class CountryRepository {

    private ApiNetworkCall apiInterface;

    public CountryRepository() {
    }

    public MutableLiveData<Country> getMovies() {
        final MutableLiveData<Country> refferAndInvitePojoMutableLiveData = new MutableLiveData<>();

        apiInterface = ApiClient.getClientAuthentication().create(ApiNetworkCall.class);
        Call<Country> call = apiInterface.getCountryDetails();
        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                if(response.body()!=null)
                {
                    refferAndInvitePojoMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
            }
        });

        return refferAndInvitePojoMutableLiveData;
    }
}
