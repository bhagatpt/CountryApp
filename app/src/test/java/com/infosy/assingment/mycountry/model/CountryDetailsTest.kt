package com.infosy.assingment.mycountry.model

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

public class CountryDetailsTest{
    private val title = "testing title"
    private val description = "testing description"
    private val image = "www.test.com"

    @Mock
    var countryDetails: CountryDetails? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`<Any>(countryDetails?.title).thenReturn(title)
        Mockito.`when`<Any>(countryDetails?.description).thenReturn(description)
        Mockito.`when`<Any>(countryDetails?.imageHref).thenReturn(image)
    }

    @Test
    fun testCountryTitle() {
        Mockito.`when`<Any>(countryDetails?.title).thenReturn(title)
        Assert.assertEquals("testing title", countryDetails?.title)
    }

    @Test
    fun testCountryDescription() {
        Mockito.`when`<Any>(countryDetails?.description).thenReturn(description)
        Assert.assertEquals("testing description", countryDetails?.description)
    }


    @Test
    fun testCountryImage() {
        Mockito.`when`<Any>(countryDetails?.imageHref).thenReturn(image)
        Assert.assertEquals("www.test.com", countryDetails?.imageHref)
    }

    @Test
    fun testCountryTitleIncorrect() {
        Mockito.`when`<Any>(countryDetails?.title).thenReturn(title)
        Assert.assertNotEquals("title", countryDetails?.title)
    }

    @Test
    fun testCountryDescriptionIncorrect() {
        Mockito.`when`<Any>(countryDetails?.description).thenReturn(description)
        Assert.assertNotEquals(" description", countryDetails?.description)
    }

    @Test
    fun testCountryImageIncorrect() {
        Mockito.`when`<Any>(countryDetails?.imageHref).thenReturn(image)
        Assert.assertNotEquals("testing www.test.com", countryDetails?.imageHref)
    }

    @After
    @Throws(java.lang.Exception::class)
    fun tearDown() {
        countryDetails = null
    }
}