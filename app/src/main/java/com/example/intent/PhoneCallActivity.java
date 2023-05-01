package com.example.intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class PhoneCallActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        navigationView.setSelectedItemId(R.id.phoneCall);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.calculator:
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(0,0);
                return true;
            case R.id.phoneCall:
                return true;
            case R.id.sendSms:
                startActivity(new Intent(getApplicationContext(),SendSMSActivity.class));
                overridePendingTransition(0,0);
                return true;
        }
        return false;
    }
}