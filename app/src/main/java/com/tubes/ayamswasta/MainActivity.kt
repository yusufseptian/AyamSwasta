package com.tubes.ayamswasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.tubes.ayamswasta.data.Repository
import com.tubes.ayamswasta.data.model.Login
import com.tubes.ayamswasta.data.model.Menu
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val loginTest = Repository.login("yudi","yudist").enqueue(object : Callback<List<Login>>{
//            override fun onResponse(call: Call<List<Login>>, response: Response<List<Login>>) {
//                if(response.isSuccessful){
//                    response.body()?.forEach {
//                        findViewById<TextView>(R.id.lblTest).setText(it.us_role_id.toString())
//                    }
//                } else {
//                    findViewById<TextView>(R.id.lblTest).setText("Error : " + response.code())
//                }
//            }
//
//            override fun onFailure(call: Call<List<Login>>, t: Throwable) {
//                findViewById<TextView>(R.id.lblTest).setText("s_Error : " + t.message)
//            }
//
//        })
        val data = Repository.getMenu("1")
        data.getMenu().enqueue(object: Callback<List<Menu>>{
            override fun onResponse(call: Call<List<Menu>>, response: Response<List<Menu>>) {
                if(response.isSuccessful){
                    response.body()!!.forEach{
                        findViewById<TextView>(R.id.lblTest).setText(it.menu_name.toString())
                    }
                } else {
                    findViewById<TextView>(R.id.lblTest).setText("Error : " + response.code())
                }
            }

            override fun onFailure(call: Call<List<Menu>>, t: Throwable) {
                findViewById<TextView>(R.id.lblTest).setText("s_Error : " + t.message)
            }

        })
    }
}