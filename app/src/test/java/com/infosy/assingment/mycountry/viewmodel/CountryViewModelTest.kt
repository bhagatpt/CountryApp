package com.infosy.assingment.mycountry.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infosy.assingment.mycountry.model.Country
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
import java.util.*


@RunWith(JUnit4::class)
class CountryViewModelTest : ViewModel() {
    @Mock
    var countries: MutableLiveData<Country?>? = null

    @Mock
    var apiClient: ApiNetworkCall? = null

    @Mock
    private var viewModel: CountryViewModel? = null

    @Mock
    private val countryRepository: CountryRepository = CountryRepository()
    private val countryRowsList: List<Country> = ArrayList<Country>()

    @Before
    @Throws(java.lang.Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = CountryViewModel()
    }

    @Test
    fun testNull() {
        Mockito.`when`<Any?>(apiClient?.countryDetails).thenReturn(null)
        Assert.assertNotNull(viewModel?.init())
    }

    @Test
    fun testApiFetchDataSuccess() {
        // Mock API response
         `when`<Any>(apiClient?.countryDetails).thenReturn(Single.just<Country>(Country()))
        viewModel?.init()
    }

    @Test
    fun testApiFetchDataError() {
        // Mock API response
        `when`<Any>(apiClient?.countryDetails).thenReturn(Single.error<Any>(Throwable("Api error")))
        viewModel?.init()
    }

   /* @Test
    fun testApiFetchDataError() {
        `when`<Any>(apiClient?.countryDetails).thenReturn(Single.error<CountryAN>(Throwable("Api error")))

        // Mockito.`when`<Any>(apiClient?.countryDetails).thenReturn(Single.error<Country>(Throwable("Api error")))
        viewModel?.init()
    }*/

    @After
    @Throws(Exception::class)
    fun tearDown() {
        apiClient = null
        viewModel = null
    }
}