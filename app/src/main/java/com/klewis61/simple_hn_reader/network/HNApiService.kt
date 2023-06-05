package com.klewis61.simple_hn_reader.network

import com.klewis61.simple_hn_reader.data.Hits
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://hn.algolia.com/api/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HNApiService{
    @GET("search?tags=front_page")
    suspend fun getTopStories() : Hits

}


object HNApi{
    val retrofitService: HNApiService by lazy{
        retrofit.create(HNApiService::class.java)
    }
}