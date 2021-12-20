package com.nishajain.fragmentskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.nishajain.fragmentskotlin.Fragment.HomeFragment
import com.nishajain.fragmentskotlin.Fragment.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val icHome = findViewById<FrameLayout>(R.id.ic_home)
        val icSettings = findViewById<FrameLayout>(R.id.ic_settings)

        replaceFragment(HomeFragment())

        icHome.setOnClickListener {
            replaceFragment(HomeFragment())

        }
        icSettings.setOnClickListener {
            replaceFragment(SettingsFragment())


        }
    }

    fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
    }
}