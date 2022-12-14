package com.example.formregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvJudul, tvNama, tvTempat, tvDate;
    private EditText etNama, etTempat, etDate;
    private Button btnSubmit ;
    private ImageButton btnDate;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvJudul = findViewById(R.id.tfViewJudul);
        tvNama = findViewById(R.id.textViewNama);
        tvTempat = findViewById(R.id.textViewTempat);
        tvDate = findViewById(R.id.textViewDate);
        etNama = findViewById(R.id.inputName);
        etTempat = findViewById(R.id.inputTempat);
        etDate = findViewById(R.id.inputDate);
        btnSubmit = findViewById(R.id.btnRegistrasi);
        btnDate = findViewById(R.id.imageButton);

        btnSubmit.setOnClickListener(this);
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        getSupportActionBar().setTitle("Kelompok 10 PBP Kelas A");
    }

    private void showDateDialog() {
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                etDate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    @Override
    public void onClick(View view) {
        String inputName = etNama.getText().toString().trim();
        String inputLocation = etTempat.getText().toString().trim();
        String inputDate = etDate.getText().toString().trim();

        boolean isEmptyFields = false;

        if (inputName.isEmpty()) {
            isEmptyFields = true;
            etNama.setError("Field ini tidak boleh kosong");
        }
        if (inputLocation.isEmpty()) {
            isEmptyFields = true;
            etTempat.setError("Field ini tidak boleh kosong");
        }
        if (inputDate.isEmpty()) {
            isEmptyFields = true;
            etDate.setError("Field ini tidak boleh kosong");
        }

        if (!isEmptyFields) {
            Intent intent = new Intent(this, ResultActivity.class);

            intent.putExtra("nama", etNama.getText().toString());
            intent.putExtra("location", etTempat.getText().toString());
            intent.putExtra("birthdate", etDate.getText().toString());

            startActivity(intent);
        }
    }

}