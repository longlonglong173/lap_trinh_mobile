package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int errorColor = Color.parseColor("#FF0000");
    int transparentColor = Color.parseColor("#FF0000");
    int textColor = Color.parseColor("#FF000000");
    EditText firstName, lastName, address, email;
    RadioGroup gender;
    TextView birthday;
    LinearLayout firstNameBg, lastNameBg, birthdayBg, addressBg, emailBg, genderBg;
    CheckBox agreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        firstNameBg = findViewById(R.id.firstNameBg);

        lastName = findViewById(R.id.lastName);
        lastNameBg = findViewById(R.id.lastNameBg);

        birthday = findViewById(R.id.birthday);
        birthdayBg = findViewById(R.id.birthdayBg);

        address = findViewById(R.id.address);
        addressBg = findViewById(R.id.addressBg);

        email = findViewById(R.id.email);
        emailBg = findViewById(R.id.emailBg);

        gender = findViewById(R.id.gender);
        genderBg = findViewById(R.id.genderBg);

        agreement = findViewById(R.id.agreement);
    }

    public void handleRegister(View view) {
        String firstNameText = firstName.getText().toString();
        if(firstNameText.equals("")) {
            firstNameBg.setBackgroundColor(errorColor);
        }else {
            firstNameBg.setBackgroundColor(transparentColor);
        }

        String lastNameText = lastName.getText().toString();
        if(lastNameText.equals("")) {
            lastNameBg.setBackgroundColor(errorColor);
        }else {
            lastNameBg.setBackgroundColor(transparentColor);
        }

        switch (gender.getCheckedRadioButtonId()) {
            case R.id.genderMale:
            case R.id.genderFemale:
                genderBg.setBackgroundColor(transparentColor);
                break;
            default:
                genderBg.setBackgroundColor(errorColor);
                break;
        }

        String addressText = address.getText().toString();
        if(addressText.equals("")) {
            addressBg.setBackgroundColor(errorColor);
        }else {
            addressBg.setBackgroundColor(transparentColor);
        }

        String emailText = email.getText().toString();
        if(emailText.equals("")) {
            emailBg.setBackgroundColor(errorColor);
        }else {
            emailBg.setBackgroundColor(transparentColor);
        }

        if(agreement.isChecked()) {
            agreement.setTextColor(textColor);
        }else {
            agreement.setTextColor(errorColor);
        }
    }
}