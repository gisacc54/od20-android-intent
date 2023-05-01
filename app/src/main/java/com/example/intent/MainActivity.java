package com.example.intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        navigationView.setSelectedItemId(R.id.calculator);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.calculator:
                return true;
            case R.id.phoneCall:
                startActivity(new Intent(getApplicationContext(),PhoneCallActivity.class));
                overridePendingTransition(0,0);
                return true;
            case R.id.sendSms:
                startActivity(new Intent(getApplicationContext(),SendSMSActivity.class));
                overridePendingTransition(0,0);
                return true;
        }
        return false;
    }
}