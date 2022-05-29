package com.tubes.ayamswasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tubes.ayamswasta.data.model.Menu
import com.tubes.ayamswasta.data.model.ResponseAction
import com.tubes.ayamswasta.data.repository.MenuMakananRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val action = MenuMakananRepository.insertMenu()
        action.insertMenu(
            "Bakpia","45000","0","Ada"
        ).enqueue(object:Callback<ResponseAction>{
            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {
                if(response.isSuccessful){
//                    response.body()?.forEach {
//                        findViewById<TextView>(R.id.lblTest).text = it.messages
//                    }\
                    findViewById<TextView>(R.id.lblTest).text = response.body()!!.messages
                } else {
                    findViewById<TextView>(R.id.lblTest).text = "err code : "+response.code().toString()
                }
            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                findViewById<TextView>(R.id.lblTest).text = t.toString()
            }

        })

//
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
//        navController = navHostFragment.navController
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}