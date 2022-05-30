package com.tubes.ayamswasta.support

import android.widget.EditText

class Validate {
    fun stringNotNull(data : Array<String>) : Boolean{
        data.forEach {
            if (it.trim() == ""){
                return false
            }
        }
        return true
    }

    fun textboxsNotNull(data : Array<EditText>) : Boolean{
        data.forEach {
            if(it.text.toString().trim() == ""){
                return false
            }
        }
        return true
    }
}