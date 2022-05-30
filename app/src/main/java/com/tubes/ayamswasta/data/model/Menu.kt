package com.tubes.ayamswasta.data.model

data class Menu(
    val menu_id : Int,
    val menu_name : String,
    val menu_harga : Long,
    val menu_disc : Int,
    val menu_status : String,
    val delete_at : String?
)