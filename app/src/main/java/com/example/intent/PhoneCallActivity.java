package com.example.intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class PhoneCallActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    public EditText etPhoneNumber;
    public Button btnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);

        //Navigation
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        //Call
        etPhoneNumber = (EditText)findViewById(R.id.etPhoneNumber);
        btnCall = (Button) findViewById(R.id.btnCall);

        //Navigation
        navigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        navigationView.setSelectedItemId(R.id.phoneCall);

        //Call
        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnCall){
            if (etPhoneNumber.getText().length()>2){
                String phoneNumber = etPhoneNumber.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+phoneNumber));
                startActivity(callIntent);
            }
        }
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