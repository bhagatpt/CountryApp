package com.infosy.assingment.mycountry.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infosy.assingment.mycountry.model.Country
import com.infosy.assingment.mycountry.repository.CountryRepository

class CountryViewModel : ViewModel() {
    var countries: MutableLiveData<Country?>? = null
        private set
    private val movieModel: CountryRepository
    fun init() {
        if (countries != null) {
            return
        }
        countries = movieModel.movies
    }

    init {
        movieModel = CountryRepository()
    }
}