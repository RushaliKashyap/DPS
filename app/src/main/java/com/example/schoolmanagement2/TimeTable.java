package com.example.schoolmanagement2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TimeTable extends AppCompatActivity {

    ListView listView;
    String[] timeTable = {"1st Class","2nd Class","3rd Class","4th Class","5th Class","6th Class","7th Class","8th Class","9th Class","10th Class"};

    int id[] = {R.drawable.one,R.drawable.two,R.drawable.threee,R.drawable.four,R.drawable.five,R.drawable.six,
                   R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        listView = findViewById(R.id.list);
        //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,cities);
        //  listView.setAdapter(adapter);
        Adapter obj = new Adapter(TimeTable.this,timeTable,id);
        listView.setAdapter(obj);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TimeTable.this,"Clicked"+timeTable[position],Toast.LENGTH_SHORT).show();

                if(position == 0)
                {
                    Intent intent = new Intent(getApplicationContext(),istclass.class);
                    startActivity(intent);
                }

                if(position == 1)
                {
                    Intent intent = new Intent(getApplicationContext(),secondclass.class);
                    startActivity(intent);
                }

                if(position == 2)
                {
                    Intent intent = new Intent(getApplicationContext(),thirdclass.class);
                    startActivity(intent);
                }
                if(position == 3)
                {
                    Intent intent = new Intent(getApplicationContext(),fourthclass.class);
                    startActivity(intent);
                }
                if(position == 4)
                {
                    Intent intent = new Intent( getApplicationContext(),Fifth.class);
                    startActivity(intent);
                }
                if(position == 5)
                {
                    Intent intent = new Intent(getApplicationContext(),sixthclass.class);
                    startActivity(intent);
                }

                if(position == 6)
                {
                    Intent intent = new Intent(getApplicationContext(),seventhclass.class);
                    startActivity(intent);
                }

                if(position == 7)
                {
                    Intent intent = new Intent(getApplicationContext(),Eightclass.class);
                    startActivity(intent);
                }

                if(position == 8)
                {
                    Intent intent = new Intent(getApplicationContext(),Ninthclass.class);
                    startActivity(intent);
                }
                if(position == 9)
                {
                    Intent intent = new Intent(getApplicationContext(),Tenthclass.class);
                    startActivity(intent);
                }

            }
        });

    }
}