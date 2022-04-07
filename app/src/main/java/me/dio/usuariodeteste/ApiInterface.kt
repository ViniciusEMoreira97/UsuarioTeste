package me.dio.usuariodeteste

import me.dio.usuariodeteste.domain.Test
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("teste.json")
    fun getTest(): Call<List<Test>>
}