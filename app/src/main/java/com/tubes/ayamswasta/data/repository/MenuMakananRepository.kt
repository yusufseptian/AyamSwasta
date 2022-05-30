package com.tubes.ayamswasta.data.repository

import com.tubes.ayamswasta.data.model.Menu
import com.tubes.ayamswasta.data.model.ResponseAction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MenuMakananRepository {
    fun getMenu() : com.tubes.ayamswasta.data.interfaces.Menu{
        return Repository.retrofit.create(com.tubes.ayamswasta.data.interfaces.Menu::class.java)
    }

    fun insertMenu() : com.tubes.ayamswasta.data.interfaces.Menu{
        return Repository.retrofit.create(com.tubes.ayamswasta.data.interfaces.Menu::class.java)
    }
}