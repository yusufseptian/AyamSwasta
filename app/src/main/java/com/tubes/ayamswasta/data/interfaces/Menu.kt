package com.tubes.ayamswasta.data.interfaces

import retrofit2.Call
import retrofit2.http.GET

interface Menu {
    @GET("menu/1/")
    fun getMenu(): Call<List<Menu>>
}