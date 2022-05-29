package com.tubes.ayamswasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class admin : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menuItem1->Toast.makeText(applicationContext, "Clicked Item 1", Toast.LENGTH_SHORT).show()
                R.id.menuItem2->Toast.makeText(applicationContext, "Clicked Item 2", Toast.LENGTH_SHORT).show()
                R.id.menuItem3->Toast.makeText(applicationContext, "Clicked Item 3", Toast.LENGTH_SHORT).show()
                R.id.menuItem4->Toast.makeText(applicationContext, "Clicked Item 4", Toast.LENGTH_SHORT).show()
                R.id.menuItem5->Toast.makeText(applicationContext, "Clicked Item 5", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}