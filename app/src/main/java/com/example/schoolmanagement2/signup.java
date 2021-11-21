package com.example.schoolmanagement2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class signup extends AppCompatActivity {

    EditText dateTxt,name,father,mother, Id,occupation,address,city,email;
    Button submit;
    private int mDate,mMonth,mYear;
    RadioGroup radioGroup;
    Spinner spn;
    String[] category = {"Select","General","OBC","SC","ST"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        dateTxt = findViewById(R.id.date);
        name = findViewById(R.id.student);
        father = findViewById(R.id.father);
        mother = findViewById(R.id.mother);
        Id = findViewById(R.id.adhar);
        occupation = findViewById(R.id.occupation);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        submit = findViewById(R.id.button);
        email = findViewById(R.id.email);
        radioGroup =findViewById(R.id.radio);
        spn = findViewById(R.id.spinner);

        ArrayAdapter arrayAdapter = new ArrayAdapter(signup.this, android.R.layout.simple_spinner_item,category);
        spn.setAdapter(arrayAdapter);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1)
                {
                    Toast.makeText(signup.this,"You select General Option",Toast.LENGTH_LONG).show();
                }
                if(position == 2)
                {
                    Toast.makeText(signup.this,"You select OBC Option",Toast.LENGTH_LONG).show();
                }
                if(position == 3)
                {
                    Toast.makeText(signup.this,"You select SC option",Toast.LENGTH_LONG).show();
                }
                if(position == 4)
                {
                    Toast.makeText(signup.this,"You Select ST Option",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar calendar = Calendar.getInstance();
                mDate = calendar.get(Calendar.DATE);
                mMonth = calendar.get(Calendar.MONTH);
                mYear = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(signup.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int date) {
                        dateTxt.setText((date+"-"+month+"-"+year));
                    }
                },mDate,mMonth,mYear);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis()-1000);
                datePickerDialog.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString();
                String FatherName = father.getText().toString();
                String MotherName = mother.getText().toString();
                String Email = email.getText().toString();
                String Address = address.getText().toString();
                String DateOfBirth = dateTxt.getText().toString();
                String Occupation = occupation.getText().toString();
                String City = city.getText().toString();
                final String[] gender = new String[1];
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton male=group.findViewById(R.id.male);
                        RadioButton female=group.findViewById(R.id.female);
                        if(male.isChecked()){
                            gender[0] ="Male";
                        }
                        else {
                            gender[0] ="Female";
                        }
                    }
                });


                if (userName.equals("") || FatherName.equals("") || Email.equals("") || Address.equals("") || DateOfBirth.equals("") ||
                        MotherName.equals("") || Occupation.equals("") || city.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter all the details", Toast.LENGTH_LONG).show();

                } else {


                    Toast.makeText(getApplicationContext(), "You Successfully submit", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}