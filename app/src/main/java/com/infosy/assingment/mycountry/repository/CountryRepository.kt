package com.infosy.assingment.mycountry.repository

import androidx.lifecycle.MutableLiveData
import com.infosy.assingment.mycountry.model.Country
import com.infosy.assingment.mycountry.network.ApiClient.clientAuthentication
import com.infosy.assingment.mycountry.network.ApiNetworkCall
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepository {
    var apiInterface: ApiNetworkCall? = null
    val movies: MutableLiveData<Country?>
        get() {
            val referAndInvitePoloMutableLiveData = MutableLiveData<Country?>()
            apiInterface = clientAuthentication!!.create<ApiNetworkCall>(ApiNetworkCall::class.java)
            if (apiInterface != null) {
                var call = apiInterface!!.countryDetails
                call!!.enqueue(object : Callback<Country?> {
                    override fun onResponse(call: Call<Country?>, response: Response<Country?>) {
                        if (response.body() != null) {
                            referAndInvitePoloMutableLiveData.setValue(response.body())
                        }
                    }
                    override fun onFailure(call: Call<Country?>, t: Throwable) {}
                })
            }
            return referAndInvitePoloMutableLiveData
        }
}