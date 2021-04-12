package com.infosy.assingment.mycountry.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.infosy.assingment.mycountry.R;
import com.infosy.assingment.mycountry.ui.CountryDetailsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CountryDetailsFragment.newInstance())
                    .commitNow();
        }
    }
}