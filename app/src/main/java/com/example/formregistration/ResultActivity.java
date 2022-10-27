package com.example.formregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    String name;
    String location;
    String birthdate;
    private TextView tvName, tvLocation, tvBirthdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        name = intent.getStringExtra("nama");
        location = intent.getStringExtra("location");
        birthdate = intent.getStringExtra("birthdate");

        tvName = findViewById(R.id.nameDisplay);
        tvLocation = findViewById(R.id.locationDisplay);
        tvBirthdate = findViewById(R.id.birthDisplay);

        tvName.setText(name);
        tvLocation.setText(location);
        tvBirthdate.setText(birthdate);



        getSupportActionBar().setTitle("Hasil Form");


    }
}