package com.example.testphincon.data.remote

import com.example.test_rpay_finance.model.Location
import retrofit2.http.GET

interface ApiService {
    @GET("/v1/ip/geo.json")
    suspend fun getLocation(): Location
}