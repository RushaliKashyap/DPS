package com.example.schoolmanagement2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class LoginForm extends AppCompatActivity {

    EditText dateTxt;
    ImageView cal;
    private int mDate,mMonth,mYear;
    Spinner spn;
    String[] category = {"Select","General","OBC","SC","ST"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        dateTxt = findViewById(R.id.date);
        cal =  findViewById(R.id.image);
        spn = findViewById(R.id.spinner);

        ArrayAdapter arrayAdapter = new ArrayAdapter(LoginForm.this, android.R.layout.simple_spinner_item,category);
        spn.setAdapter(arrayAdapter);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1)
                {
                    Toast.makeText(LoginForm.this,"You select General Option",Toast.LENGTH_LONG).show();
                }
                if(position == 2)
                {
                    Toast.makeText(LoginForm.this,"You select OBC Option",Toast.LENGTH_LONG).show();
                }
                if(position == 3)
                {
                    Toast.makeText(LoginForm.this,"You select SC option",Toast.LENGTH_LONG).show();
                }
                if(position == 4)
                {
                    Toast.makeText(LoginForm.this,"You Select ST Option",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar calendar = Calendar.getInstance();
                mDate = calendar.get(Calendar.DATE);
                mMonth = calendar.get(Calendar.MONTH);
                mYear = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(LoginForm.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int date) {
                        dateTxt.setText(date+"-"+month+"-"+year);
                    }
                },mDate,mMonth,mYear);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis()-1000);
                datePickerDialog.show();
            }
        });
    }
}