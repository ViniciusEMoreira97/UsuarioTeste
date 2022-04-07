package me.dio.usuariodeteste

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getTest(): Call<List<MyDataItem>>
}