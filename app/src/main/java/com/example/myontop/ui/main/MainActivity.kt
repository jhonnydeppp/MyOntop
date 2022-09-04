package com.example.myontop.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myontop.R
import com.example.myontop.presentation.contractor.ContractorFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ContractorFragment.newInstance())
                .commitNow()
        }
    }
}