package com.example.intent;

import android.Manifest;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class SendSMSActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    public Button btnSendSMS;
    public EditText etPhoneNumber,etMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_smsactivity);

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        //Send SMS
        etPhoneNumber = (EditText)findViewById(R.id.etPhoneNumber);
        etMessage = (EditText)findViewById(R.id.etMessage);
        btnSendSMS = (Button) findViewById(R.id.btnSendSMS);

        navigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        navigationView.setSelectedItemId(R.id.sendSms);

        btnSendSMS.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSendSMS){

            if (this.checkPermission()){
                if (etPhoneNumber.getText().length()>2 && etMessage.getText().length()>2){

                    String phoneNumber = etPhoneNumber.getText().toString();
                    String message = etMessage.getText().toString();

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);

                    Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public boolean checkPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);

            return false;

        }
        return true;
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
                startActivity(new Intent(getApplicationContext(),PhoneCallActivity.class));
                overridePendingTransition(0,0);
                return true;
            case R.id.sendSms:
                return true;
        }
        return false;
    }
}