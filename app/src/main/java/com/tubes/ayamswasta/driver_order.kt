package com.tubes.ayamswasta

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.tubes.ayamswasta.data.model.Account
import com.tubes.ayamswasta.data.repository.AccountRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class driver_order : AppCompatActivity() {
    private var us_id : String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_order)

        init()
    }

    private fun init(){
        this.us_id = intent.extras?.getString("us_id").toString()
        val context = this
//        Toast.makeText(this, "login/" + intent.extras?.getString("us_id").toString(),Toast.LENGTH_LONG).show()

        val lblID = findViewById<TextView>(R.id.txt_id_driver)
        val lblNamaUser = findViewById<TextView>(R.id.txt_nama_driver)

        AccountRepository.getAccount().myAccount(
            "user/" + intent.extras?.getString("us_id").toString()
        ).enqueue(object : Callback<Account>{
            override fun onResponse(call: Call<Account>, response: Response<Account>) {
                if (response.isSuccessful){
                    lblID.text = response.body()!!.us_id
                    lblNamaUser.text = response.body()!!.us_fullname
                } else {
                    Toast.makeText(context, "Error code : " + response.code().toString(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_LONG).show()
            }

        })
    }
}