package com.tubes.ayamswasta.data.repository

import android.widget.Button
import com.google.gson.GsonBuilder
import com.tubes.ayamswasta.data.interfaces.Login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {
    val gson = GsonBuilder().setLenient().create()
    val retrofit = Retrofit.Builder()
        .baseUrl("http://tubespml.000webhostapp.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun login() : Login {
        return retrofit.create(Login::class.java)
    }
}