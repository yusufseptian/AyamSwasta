package com.tubes.ayamswasta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tubes.ayamswasta.data.model.Login
import com.tubes.ayamswasta.data.repository.Repository
import com.tubes.ayamswasta.support.Validate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    private fun clearTextbox(){
        findViewById<EditText>(R.id.textbox_username).text = null
        findViewById<EditText>(R.id.textbox_password).text = null
    }

    fun logins(v : View){
        val context = this
        if(Validate().textboxsNotNull(
                arrayOf(
                    findViewById(R.id.textbox_username),
                    findViewById(R.id.textbox_password)
                )
        )){
            Repository.login().login(
                findViewById<EditText>(R.id.textbox_username).text.toString(),
                findViewById<EditText>(R.id.textbox_password).text.toString()
            ).enqueue(object : Callback<Login>{
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if(response.isSuccessful){
                        if(response.body()!!.us_role_id=="1"){
                            val intent = Intent(this@login,MainActivity::class.java)
                            intent.putExtra("username", findViewById<EditText>(R.id.textbox_username).text.toString())
                            intent.putExtra("us_id", response.body()!!.us_id)
                            startActivity(intent)
                            clearTextbox()
                        } else if (response.body()!!.us_role_id=="3"){
                            val intent = Intent(this@login,driver_order::class.java)
                            intent.putExtra("us_id", response.body()!!.us_id)
                            startActivity(intent)
                            clearTextbox()
                        } else if (response.body()!!.us_role_id=="2") {
                            val intent = Intent(this@login, admin::class.java)
                            intent.putExtra("us_id", response.body()!!.us_id)
                            startActivity(intent)
                            clearTextbox()
                        } else{
                            Toast.makeText(context, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(context, "Error Code : " + response.code().toString(), Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<Login>, t: Throwable) {
                    Toast.makeText(context, "Koneksi gagal", Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show()
        }
    }

    fun register(v : View){
        clearTextbox()
        startActivity(Intent(this, register::class.java))
    }
}