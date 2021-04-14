package com.infosy.assingment.mycountry.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infosy.assingment.mycountry.model.Country
import com.infosy.assingment.mycountry.model.CountryDetails
import com.infosy.assingment.mycountry.network.ApiNetworkCall
import com.infosy.assingment.mycountry.repository.CountryRepository
import io.reactivex.Single
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


@RunWith(JUnit4::class)
class CountryViewModelTest : ViewModel() {
    @Mock
    var countries: MutableLiveData<Country?>? = null

    @Mock
    var apiClient: ApiNetworkCall? = null
    private var viewModel: CountryViewModel? = null

    @Mock
    private val countryRepository: CountryRepository = CountryRepository()

    @Before
    @Throws(java.lang.Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testNull() {
        Mockito.`when`<Any?>(apiClient?.countryDetails).thenReturn(null)
    }


    @Test
    fun testApiFetchDataSuccess() {
        `when`<Any>(apiClient?.countryDetails).thenReturn(ArrayList<Country>())
        viewModel?.countries
    }


    @Test
    fun testApiFetchDataError() {
        Mockito.`when`<Any>(apiClient?.countryDetails).thenReturn(Single.error<Any>(Throwable("Api error")))
        viewModel?.countries
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        apiClient = null
        viewModel = null
    }
}