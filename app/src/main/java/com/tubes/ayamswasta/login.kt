package com.tubes.ayamswasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.tubes.ayamswasta.data.repository.Repository

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun logins(v : View){
        val test = Repository.login(
            findViewById<EditText>(R.id.textbox_username).text.toString(),
            findViewById<EditText>(R.id.textbox_password).text.toString(),
            findViewById<Button>(R.id.btn_login)
        )
    }
}