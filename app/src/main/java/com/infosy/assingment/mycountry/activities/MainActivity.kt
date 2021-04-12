package com.infosy.assingment.mycountry.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.infosy.assingment.mycountry.R
import com.infosy.assingment.mycountry.ui.CountryDetailsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CountryDetailsFragment.newInstance())
                    .commitNow()
        }
    }
}