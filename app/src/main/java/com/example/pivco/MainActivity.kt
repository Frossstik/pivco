package com.example.pivco

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pivco.Fragments.HomeFragment
import com.example.pivco.Fragments.LoginFragment
import com.example.pivco.Fragments.OnboardFragment
import com.example.pivco.Fragments.RegisterFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigateToOnboard()
        }
    }

    fun navigateToOnboard() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, OnboardFragment())
            .commit()
    }

    fun navigateToLogin() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, LoginFragment())
            .addToBackStack(null)
            .commit()
    }

    fun navigateToRegister() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, RegisterFragment())
            .addToBackStack(null)
            .commit()
    }

    fun navigateToHome() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment())
            .commit()
    }
}