package com.tubes.ayamswasta.data

import com.tubes.ayamswasta.data.interfaces.Login
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://192.168.8.119/")
        .build()

    fun login(username:String, password:String) : Call<com.tubes.ayamswasta.data.model.Login> {
        val service = retrofit.create(Login::class.java)
        val data = JSONObject()
        data.put("us_username",username)
        data.put("us_password", password)
        val dataString = data.toString()
        val requestBody = dataString.toRequestBody("application/json".toMediaTypeOrNull())
        return service.login(requestBody)
    }
}