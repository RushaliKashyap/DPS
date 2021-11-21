package com.example.schoolmanagement2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPage extends AppCompatActivity {

    EditText edit1,edit2,edit3,edit4,edit5;
    TextView text;
    Button button;
    RadioGroup radioGroup;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    public String gender="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        mAuth = FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        edit4 = findViewById(R.id.edit4);
        edit5 = findViewById(R.id.edit5);
        text = findViewById(R.id.text);
        button = findViewById(R.id.button);
        radioGroup=findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton male=group.findViewById(R.id.male);
                RadioButton female=group.findViewById(R.id.female);
                if(male.isChecked()){
                    gender +="Male";
                }
                else {
                    gender +="Female";
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FullName = edit1.getText().toString();
                String UserName = edit2.getText().toString();
                String Email = edit3.getText().toString();
                String Password = edit4.getText().toString();
                String Conform = edit5.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                 if(FullName.equals("") || UserName.equals("") || Email.equals("") || Password.equals("") || Conform.equals(""))
                 {
                     Toast.makeText(getApplicationContext(),"Please fill  above the column carefully!!",Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     if(Email.matches(emailPattern) && Password.length()>=6){
                         mAuth.createUserWithEmailAndPassword(Email, Password)
                                 .addOnCompleteListener(RegisterPage.this, new OnCompleteListener<AuthResult>() {
                                     @Override
                                     public void onComplete(@NonNull Task<AuthResult> task) {
                                         if (task.isSuccessful()) {
                                             // Sign in success, update UI with the signed-in user's information
                                             Log.d(" Firebase-User ", "createUserWithEmail:success");
                                             FirebaseUser user = mAuth.getCurrentUser();
                                             UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                     .setDisplayName(""+FullName)
                                                     .setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
                                                     .build();
                                             user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                 @Override
                                                 public void onComplete(@NonNull Task<Void> task) {
                                                     if (task.isSuccessful()) {
                                                         Log.d("Display name", "User profile updated.");
                                                     }
                                                 }
                                             });



                                             UserDetail userDetail=new UserDetail(FullName,UserName,Email,Password,gender);
                                             mDatabase.child("user").child(user.getUid()).setValue(userDetail);

                                             //  updateUI(user);
                                             Toast.makeText(getApplicationContext(),"You Succussfully Registed ",Toast.LENGTH_SHORT).show();
                                             Intent intent = new Intent(getApplicationContext(),loginpage.class);
                                             startActivity(intent);
                                             Toast.makeText(RegisterPage.this,"user "+user,Toast.LENGTH_LONG).show();
                                         } else {
                                             // If sign in fails, display a message to the user.
                                             Log.w(" Firebase-User ", "createUserWithEmail:failure", task.getException());
                                             Toast.makeText(RegisterPage.this, "Authentication failed.",
                                                     Toast.LENGTH_SHORT).show();
                                             //  updateUI(null);
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