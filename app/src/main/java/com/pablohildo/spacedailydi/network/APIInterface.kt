package com.pablohildo.spacedailydi.network

import retrofit2.http.GET

const val API_KEY = "DXdA41dWSGqsdvjJBH8ldPtBNUAvggwDuasVawgP"

interface APIInterface {
    @GET("apod?api_key=$API_KEY")
    suspend fun getDailyPhoto(): PhotoResponse
}