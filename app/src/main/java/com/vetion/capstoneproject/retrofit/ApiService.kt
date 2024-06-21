package com.vetion.capstoneproject.retrofit

import com.vetion.capstoneproject.response.Data
import com.vetion.capstoneproject.response.LoginResponse
import com.vetion.capstoneproject.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun signup(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): RegisterResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): LoginResponse

    @GET("/tips/{name}")
    fun getTips(
        @Path("name") name: String): Call<Data>

    @GET("/tips")
    fun getAllTips(): Call<List<Data>>

    @GET("/tips/search/{keyword}")
    fun searchTips(@Path("keyword") keyword: String): Call<List<Data>>
}