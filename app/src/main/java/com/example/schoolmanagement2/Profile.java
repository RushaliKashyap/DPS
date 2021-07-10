package com.example.schoolmanagement2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    EditText name,email,phone,Class,rollNo,something,address;

    TextView profile;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile = findViewById(R.id.text1);

        name = findViewById(R.id.text2);
        email = findViewById(R.id.text3);
        phone = findViewById(R.id.text4);
        Class = findViewById(R.id.text5);
        rollNo = findViewById(R.id.text6);
        something = findViewById(R.id.text7);
        address = findViewById(R.id.text8);

        save = findViewById(R.id.button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(),"Your Information will be Updated",Toast.LENGTH_SHORT).show();
            }
        });

    }
}