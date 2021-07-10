package com.example.schoolmanagement2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginpage extends AppCompatActivity {

    EditText editText1,editText2;
  Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        editText1 = findViewById(R.id.edit1);
        editText2 = findViewById(R.id.edit2);

        button1 = findViewById(R.id.Button1);
        button2 = findViewById(R.id.Button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText1.getText().toString();
                String Password = editText2.getText().toString();
                if(  userName.equals("") || Password.equals("") )
                {
                    Toast.makeText(getApplicationContext(),"You fill the all column",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"You Login SuccessFully ",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),signup.class);
                    startActivity(intent);

                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You come in registration Page!!",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),RegisterPage.class);
                startActivity(intent);
            }
        });

    }
}