package com.tubes.ayamswasta.data.interfaces

import com.tubes.ayamswasta.data.model.Menu
import com.tubes.ayamswasta.data.model.ResponseAction
import retrofit2.Call
import retrofit2.http.*

interface Menu {
    @GET
    fun getMenu(
        @Url url : String
    ): Call<List<Menu>>

    @POST("menu")
    @FormUrlEncoded
    fun insertMenu(
        @Field("menu_name") menu_name : String,
        @Field("menu_harga") menu_harga : String,
        @Field("menu_disc") menu_disc : String,
        @Field("menu_status") menu_status : String
    ) : Call<ResponseAction>
}