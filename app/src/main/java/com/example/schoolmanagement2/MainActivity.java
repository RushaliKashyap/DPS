package com.example.schoolmanagement2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {





    CardView card1,card2,card3,card4,card5,card6;
    ImageView profile,form,fees,Attendence,result,TimeTable,leftIcon,rightIcon;

    ImageView Boy,sinup,structure,atten,res,time;

    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,title;
    Toolbar tool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        tool = findViewById(R.id.toolbar);


        Boy = findViewById(R.id.boy);
        sinup = findViewById(R.id.sinUp);
        structure = findViewById(R.id.fees);
        atten = findViewById(R.id.atten);
        res = findViewById(R.id.res);
        time = findViewById(R.id.clock);


        textView1 = findViewById(R.id.profile);
        textView2 = findViewById(R.id.form);
        textView3 = findViewById(R.id.feesStructure);
        textView4 = findViewById(R.id.timeTable);
        textView5 = findViewById(R.id.Result);
        leftIcon = findViewById(R.id.leftIcon);
        rightIcon = findViewById(R.id.rightIcon);
        title = findViewById(R.id.title);
       // setSupportActionBar(tool);



        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Profile.class);
                startActivity(intent);
            }
        });


        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,loginpage.class);
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,FeesStructure.class);
                startActivity(intent);

            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TimeTable.class);
                startActivity(intent);
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Result.class);
                startActivity(intent);
            }
        });

        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"You Clicked in leftIcon",Toast.LENGTH_SHORT).show();
            }
        });

        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"You Clicked in right Icon",Toast.LENGTH_SHORT).show();
            }
        });
        title.setText("School Management");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.item1)
        {
            Toast.makeText(MainActivity.this,"About us Selected",Toast.LENGTH_LONG).show();
        }
        if(id == R.id.item2)
        {
            Toast.makeText(MainActivity.this,"Contact us Selected",Toast.LENGTH_LONG).show();
        }

        if(id == R.id.item3)
        {
            Toast.makeText(MainActivity.this,"Notification",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}