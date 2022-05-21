package com.tubes.ayamswasta.data.interfaces


import com.tubes.ayamswasta.data.model.Login
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Login {
    @POST("login/")
    fun login(@Body requestBody: RequestBody): Call<Login>
}