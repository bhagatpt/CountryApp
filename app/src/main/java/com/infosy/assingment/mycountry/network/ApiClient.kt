package com.infosy.assingment.mycountry.network

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException

object ApiClient {
    private var retrofit: Retrofit? = null
    const val URL_BASE = "https://dl.dropboxusercontent.com" //Base URL

    // .baseUrl(URL_BASE)
    val clientAuthentication: Retrofit?
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            val builder = Retrofit.Builder()
                    .baseUrl(URL_BASE)
            val interceptor = AuthenticationInterceptor(
                    Credentials.basic("", ""))
            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor)
                httpClient.addInterceptor(logging)
                builder.client(httpClient.build())
                retrofit = builder // .baseUrl(URL_BASE)
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build()
            }
            return retrofit
        }

    class AuthenticationInterceptor(private val authToken: String) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            val builder = original.newBuilder()
                    .header("Authorization", authToken) //Remember header() vs addHeader
            val request = builder.build()
            return chain.proceed(request)
        }
    }
}