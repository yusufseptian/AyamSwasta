package com.tubes.ayamswasta

import android.content.Context
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

        findViewById<TextView>(R.id.lblUser).text = "Selamat datang, " + intent.extras?.getString("username").toString()

        val session = getSharedPreferences("account", Context.MODE_PRIVATE).edit()
        session.putString("username", findViewById<TextView>(R.id.lblUser).text.toString())
        session.putString("us_id", intent.extras?.getString("us_id").toString())
        session.commit()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}