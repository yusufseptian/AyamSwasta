package com.tubes.ayamswasta.data.interfaces


import com.tubes.ayamswasta.data.model.Login
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Login {
    @POST("login")
    @FormUrlEncoded
    fun login(
        @Field ("us_username") us_username : String,
        @Field ("us_password") us_password : String,
    ): Call<Login>
}