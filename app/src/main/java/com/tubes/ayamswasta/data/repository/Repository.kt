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

    fun login(username:String, password:String, btn:Button) {
        val service = retrofit.create(Login::class.java)
//        val data = JSONObject()
//        data.put("us_username",username)
//        data.put("us_password", password)
//        val dataString = data.toString()
//        val requestBody = dataString.toRequestBody("application/json".toMediaTypeOrNull())
//        val params = LoginParam(username, password)
//        var result = com.tubes.ayamswasta.data.model.Login(us_role_id = "90")
        service.login(username, password).enqueue(object: Callback<com.tubes.ayamswasta.data.model.Login>{
            override fun onResponse(
                call: Call<com.tubes.ayamswasta.data.model.Login>,
                response: Response<com.tubes.ayamswasta.data.model.Login>
            ) {
                if(response.isSuccessful){
                    btn.text = response.body()!!.us_role_id
                }else{
                    btn.text = response.code().toString()
                }
            }
            override fun onFailure(
                call: Call<com.tubes.ayamswasta.data.model.Login>,
                t: Throwable
            ) {
                btn.text = t.toString()
            }

        })
//        return result
    }
}