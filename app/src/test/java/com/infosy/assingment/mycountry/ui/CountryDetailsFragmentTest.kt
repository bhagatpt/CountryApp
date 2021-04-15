package com.infosy.assingment.mycountry.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.load.engine.Resource
import com.infosy.assingment.mycountry.custom.CheckConnection
import com.infosy.assingment.mycountry.model.Country
import com.infosy.assingment.mycountry.model.CountryDetails
import com.infosy.assingment.mycountry.repository.CountryRepository
import com.infosy.assingment.mycountry.viewmodel.CountryViewModel
import io.reactivex.Single
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.util.*

@RunWith(JUnit4::class)
class CountryDetailsFragmentTest : Fragment() {

    private lateinit var countryViewModel: CountryViewModel
    private lateinit var countryDetailsFragmentTest: CountryDetailsFragment

    @Mock
    private lateinit var countryRepository: CountryRepository

    private lateinit var observer: Observer<Resource<Country>>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        countryViewModel = CountryViewModel()
        countryDetailsFragmentTest = CountryDetailsFragment()
    }

    @Test
    fun testWhenDataListSuccess() {
        val list = mutableListOf<CountryDetails>()
        list.add(0, CountryDetails("Country Title", "Country Description", ""))
        lateinit var countryResponse: MutableLiveData<Resource<CountryDetails>>
        countryViewModel.countries?.value = Country("Canada", list)
       // `when`(countryViewModel.init()).thenReturn()
    }

    @Test
    fun testWhenDataListError() {
        val list = mutableListOf<CountryDetails>()
        list.add(0, CountryDetails(" ", " ", ""))
        lateinit var countryResponse: MutableLiveData<Resource<CountryDetails>>
    }
}