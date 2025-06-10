package com.example.animewiki.data.remote

import com.example.animewiki.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface AnimeApi {
    /*
    * This interface is where we use the retrofit lib to declare the get requests
    * that are used to fetch data from backend server.
    * */

    @GET("/anime/heroes")
    suspend fun getAllHeroes(
        @Query(value = "page") page: Int = 1
    ): ApiResponse

    @GET("/anime/heroes/search")
    suspend fun searchHeroes(
        @Query(value = "name") name: String
    ): ApiResponse
}