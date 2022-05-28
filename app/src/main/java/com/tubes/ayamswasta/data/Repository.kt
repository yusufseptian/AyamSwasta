package com.tubes.ayamswasta.data

import com.google.gson.GsonBuilder
import com.tubes.ayamswasta.data.interfaces.Login
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object Repository {
    val gson = GsonBuilder().setLenient().create()
    val retrofit = Retrofit.Builder()
        .baseUrl("http://tubespml.000webhostapp.com/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun login(username:String, password:String) : Call<List<com.tubes.ayamswasta.data.model.Login>> {
        val service = retrofit.create(Login::class.java)
        val data = JSONObject()
        data.put("us_username",username)
        data.put("us_password", password)
        val dataString = data.toString()
        val requestBody = dataString.toRequestBody("application/json".toMediaTypeOrNull())
        return service.login(requestBody)
    }

    fun getMenu(key:String) : com.tubes.ayamswasta.data.interfaces.Menu{
        return retrofit.create(com.tubes.ayamswasta.data.interfaces.Menu::class.java)
    }

}