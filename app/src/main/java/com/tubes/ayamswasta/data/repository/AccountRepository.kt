package com.tubes.ayamswasta.data.repository

import com.tubes.ayamswasta.data.interfaces.Account

object AccountRepository {
    fun getAccount() : Account{
        return Repository.retrofit.create(Account::class.java)
    }
}