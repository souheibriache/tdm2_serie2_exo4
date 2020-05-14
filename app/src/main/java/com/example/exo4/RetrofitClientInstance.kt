package com.example.exo4

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClientInstance {

    private lateinit var retrofit: Retrofit
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    val retrofitInstance: Retrofit
        get() {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            return retrofit
        }
}