package com.tubes.ayamswasta.data.model

data class Account(
    val us_id : String,
    val us_username : String,
    val us_fullname : String,
    val us_password : String,
    val us_alamat : String,
    val us_telepon : String,
    val us_role_id : String,
    val delete_at : String?
)
