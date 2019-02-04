package com.example.noy.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Vector;


public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//settings of design -DO NOT TOUCH
        setContentView(R.layout.activity_main);//settings of design -DO NOT TOUCH
        getSupportActionBar().hide();

        Button make_my_calendar = (Button) findViewById(R.id.button);
        Button view_my_calendar = (Button) findViewById(R.id.button_view);
        View.OnClickListener myHandler=new View.OnClickListener(){
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), "Building Your Calendar", Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(Main.this,EditEventActivity_2.class);
                startActivity(myIntent);
            }
        };

        View.OnClickListener showCalendar=new View.OnClickListener(){
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), "Building Your Calendar", Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(Main.this,ListViewLoader.class);
                startActivity(myIntent);
            }
        };

        make_my_calendar.setOnClickListener(myHandler);
        view_my_calendar.setOnClickListener(showCalendar);
    }
}


