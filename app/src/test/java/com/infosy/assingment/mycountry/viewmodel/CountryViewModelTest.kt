package com.infosy.assingment.mycountry.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infosy.assingment.mycountry.model.Country
import com.infosy.assingment.mycountry.repository.CountryRepository
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CountryViewModelTest : ViewModel() {
    @Rule
    var countries: MutableLiveData<Country?>? = null
    @Rule
    private val movieModel: CountryRepository = CountryRepository()
    @Test
    fun init() {
        if (countries != null) {
            countries.let { "$it".length }
            return
        }
        countries = movieModel.movies
    }

}