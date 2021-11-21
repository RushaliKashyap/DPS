package com.example.schoolmanagement2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    EditText name,email,phone,Class,rollNo,something,address;

    TextView profile;
    Button save;

    private DatabaseReference databaseReference;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onStart() {
        super.onStart();




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        profile = findViewById(R.id.text1);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        name = findViewById(R.id.text2);
        email = findViewById(R.id.text3);
        phone = findViewById(R.id.text4);
        Class = findViewById(R.id.text5);
        rollNo = findViewById(R.id.text6);
        something = findViewById(R.id.text7);
        address = findViewById(R.id.text8);

        save = findViewById(R.id.button);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
      //  DatabaseReference myRef = database.child("user/");

        database.child("user").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserRead user = dataSnapshot.getValue(UserRead.class);
                Log.d("firebase const"," "+user.getEmail()+" "+user.email);
                name.setText(user.fullName);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}

        });


        databaseReference.child("user").child(user.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(),"Your Information will be Updated",Toast.LENGTH_SHORT).show();
            }
        });

    }
}