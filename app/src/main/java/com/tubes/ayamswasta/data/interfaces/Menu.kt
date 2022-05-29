package com.tubes.ayamswasta.data.interfaces

import com.tubes.ayamswasta.data.model.Menu
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface Menu {
    @GET
    fun getMenu(
        @Url url : String
    ): Call<List<Menu>>
}