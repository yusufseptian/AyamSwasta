package com.tubes.ayamswasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.tubes.ayamswasta.data.model.ResponseAction
import com.tubes.ayamswasta.data.repository.AccountRepository
import com.tubes.ayamswasta.support.Validate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    private fun clearTextbox(){
        findViewById<EditText>(R.id.textbox_username).text = null
        findViewById<EditText>(R.id.textbox_password).text = null
        findViewById<EditText>(R.id.textbox_confirm_password).text = null
    }

    fun register(v : View){
        val context = this
        val uname = findViewById<EditText>(R.id.textbox_username).text.toString()
        val pass = findViewById<EditText>(R.id.textbox_password).text.toString()
        val cpass = findViewById<EditText>(R.id.textbox_confirm_password).text.toString()

        if(Validate().stringNotNull(
                arrayOf(uname, pass, cpass)
        )){
            if(pass == cpass){
                AccountRepository.getAccount().register(
                    uname, pass
                ).enqueue(object : Callback<ResponseAction>{
                    override fun onResponse(
                        call: Call<ResponseAction>,
                        response: Response<ResponseAction>
                    ) {
                        if(response.isSuccessful){
                            clearTextbox()
                            Toast.makeText(context, response.body()!!.messages, Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Error code : " + response.code().toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                        Toast.makeText(context, "Koneksi gagal", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(context, "Password dan confirm password harus sama", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "Data tidak boleh kosong!", Toast.LENGTH_SHORT).show()
        }
    }
}