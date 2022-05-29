package com.tubes.ayamswasta.data.repository

import com.tubes.ayamswasta.data.model.Menu
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MenuMakananRepository {
    fun getMenu(key:String) : ArrayList<Menu>{
        val service =  Repository.retrofit.create(com.tubes.ayamswasta.data.interfaces.Menu::class.java)
        val result = ArrayList<Menu>()
        service.getMenu(key).enqueue(object: Callback<List<Menu>>{
            override fun onResponse(call: Call<List<Menu>>, response: Response<List<Menu>>) {
                if(response.isSuccessful){
                    response.body()?.forEach {
                        result.add(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<Menu>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return result
    }

    fun insertMenu(){

    }
}