package com.infosy.assingment.mycountry.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infosy.assingment.mycountry.model.Country
import com.infosy.assingment.mycountry.repository.CountryRepository

class CountryViewModel : ViewModel() {
    var countries: MutableLiveData<Country?>? = null
    private val movieModel: CountryRepository = CountryRepository()
    fun init() {
        if (countries != null) {
            countries.let { "$it".length }
            return
        }
        countries = movieModel.movies
    }

}