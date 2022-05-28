package com.tubes.ayamswasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tubes.ayamswasta.data.Repository
import com.tubes.ayamswasta.data.model.Login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
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

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}