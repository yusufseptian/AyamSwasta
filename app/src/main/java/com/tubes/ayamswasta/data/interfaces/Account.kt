package com.tubes.ayamswasta.data.interfaces

import com.tubes.ayamswasta.data.model.Account
import com.tubes.ayamswasta.data.model.ResponseAction
import retrofit2.Call
import retrofit2.http.*

interface Account {
    @POST("user")
    @FormUrlEncoded
    fun register(
        @Field("us_username") us_username : String,
        @Field("us_password") us_password : String
    ) : Call<ResponseAction>

    @GET
    fun myAccount(@Url url : String) : Call<Account>

    @DELETE("user/{id}")
    fun deleteMe(@Path("id") id:String) : Call<ResponseAction>

    @PUT("user/{id}")
    fun updateMe(
        @Path("id") id:String,
        @Field("us_fullname") us_fullname : String,
        @Field("us_telepon") us_telepon : String,
        @Field("us_alamat") us_alamat : String
    ) : Call<ResponseAction>
}