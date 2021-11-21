package com.example.schoolmanagement2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginpage extends AppCompatActivity {

    EditText editText1,editText2;
  Button button1,button2;
    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentuser=mAuth.getCurrentUser();
        if(currentuser!=null){

            Toast.makeText(loginpage.this,"welcome "+ currentuser.getDisplayName(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        else {

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        mAuth = FirebaseAuth.getInstance();
        editText1 = findViewById(R.id.edit1);
        editText2 = findViewById(R.id.edit2);

        button1 = findViewById(R.id.Button1);
        button2 = findViewById(R.id.Button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText1.getText().toString();
                String Password = editText2.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(  userName.equals("") || Password.equals("") )
                {
                    Toast.makeText(getApplicationContext(),"You fill the all column",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(userName.matches(emailPattern) && Password.length() >=6){
                        mAuth.signInWithEmailAndPassword(userName, Password).addOnCompleteListener(loginpage.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(loginpage.this,"You Login SuccessFully ",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent);
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("Login", "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    // updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("Login Fail", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(loginpage.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    //   updateUI(null);
                                }
                            }
                        });
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
                    }



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