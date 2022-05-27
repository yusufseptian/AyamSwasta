package com.tubes.ayamswasta.data.interfaces


import com.tubes.ayamswasta.data.model.Login
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Login {
    @Headers("Content-Type: application/json")
    @POST("api/login.php")
    fun login(@Body requestBody: RequestBody): Call<List<Login>>
}