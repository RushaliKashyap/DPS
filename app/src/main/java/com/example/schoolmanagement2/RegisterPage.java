package com.example.schoolmanagement2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterPage extends AppCompatActivity {

    EditText edit1,edit2,edit3,edit4,edit5;
    TextView text;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);


        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        edit4 = findViewById(R.id.edit4);
        edit5 = findViewById(R.id.edit5);
        text = findViewById(R.id.text);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FullName = edit1.getText().toString();
                String UserName = edit2.getText().toString();
                String Email = edit3.getText().toString();
                String Password = edit4.getText().toString();
                String Conform = edit5.getText().toString();
                 if(FullName.equals("") || UserName.equals("") || Email.equals("") || Password.equals("") || Conform.equals(""))
                 {
                     Toast.makeText(getApplicationContext(),"Please fill  above the column carefully!!",Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     Toast.makeText(getApplicationContext(),"You Succussfully Registed ",Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(getApplicationContext(),loginpage.class);
                     startActivity(intent);
                 }


            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You come to LoginPage",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),loginpage.class);
                startActivity(intent);
            }
        });
    }
}