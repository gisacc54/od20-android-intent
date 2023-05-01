package com.example.intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    public EditText etFirstNumber,etSecondNumber;
    public TextView tvAnswer;
    public Button btnPlus,btnMinus,btnTimes,btnDivide,btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Navigation
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);

        //Calculator
        etFirstNumber = (EditText)findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText)findViewById(R.id.etSecondNumber);
        tvAnswer = (TextView)findViewById(R.id.tvAnswer);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnTimes = (Button)findViewById(R.id.btnTimes);
        btnDivide = (Button)findViewById(R.id.btnDivide);
        btnClear = (Button)findViewById(R.id.btnClear);

        //Navigation
        navigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        navigationView.setSelectedItemId(R.id.calculator);

        //Calculator
        btnPlus.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnTimes.setOnClickListener(this);
        btnMinus.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if((etFirstNumber.getText().length()>0 && etSecondNumber.getText().length()>0)){
            double number1 = Double.parseDouble(etFirstNumber.getText().toString());
            double number2 = Double.parseDouble(etSecondNumber.getText().toString());
            this.calculator(view.getId(),number1,number2);
        }else if (view.getId() ==  R.id.btnClear){
            etFirstNumber.setText("");
            etSecondNumber.setText("");
            tvAnswer.setText("");
        }

    }

    public void calculator(int id,double number1,double number2){
        double answer = 0.0;
        String answerString = "";
        switch (id){
            case R.id.btnPlus:
                answer = number1+number2;
                answerString = Double.toString(answer);
                break;
            case R.id.btnMinus:
                answer = number1-number2;
                answerString = Double.toString(answer);
                break;
            case R.id.btnTimes:
                answer = number1*number2;
                answerString = Double.toString(answer);
                break;
            case R.id.btnDivide:
                answer = number1/number2;
                answerString = Double.toString(answer);
                break;
            case R.id.btnClear:
                etFirstNumber.setText("");
                etSecondNumber.setText("");
                break;
        }
        tvAnswer.setText(answerString);
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