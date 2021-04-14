package com.infosy.assingment.mycountry.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*
import kotlin.collections.ArrayList

public class CountryTest {

    private val title = "Testing Title"
    private val countryRowsList: List<CountryDetails> = ArrayList<CountryDetails>()

    @Mock
    var country: Country? = Country()

    @Mock
    var countryDetails: List<CountryDetails>? = ArrayList<CountryDetails>()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`<Any>(country?.title).thenReturn(title)
        Mockito.`when`<Any>(country?.rows).thenReturn(countryRowsList)
    }

    @Test
    fun testCountryTitle() {
        Mockito.`when`<Any>(country?.title).thenReturn(title)
        Assert.assertEquals("Testing Title", country?.title)
    }

    @Test
    fun testCountryDetails() {
        Mockito.`when`<Any>(country?.rows).thenReturn(countryRowsList)
        Assert.assertEquals(ArrayList<CountryDetails>(), country?.rows)
    }

    @Test
    fun testCountryTitleIncorrect() {
        Mockito.`when`<Any>(country?.title).thenReturn(title)
        Assert.assertNotEquals(" title", country?.title)
    }

    @Test
    fun testCountryDetailsIncorrect() {
        Mockito.`when`<Any>(country?.rows).thenReturn(countryRowsList)
        Assert.assertNotEquals(" ddf", country?.rows)
    }
}