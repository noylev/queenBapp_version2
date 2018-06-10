package com.example.noy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Vector;


public class MainList_1 extends AppCompatActivity  {
    ClassicSingleton app_manager_memory = ClassicSingleton.getInstance();
    Vector<CalendarEvent> calendarEventsVector = app_manager_memory.getCalendarEvents();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//settings of design -DO NOT TOUCH
        setContentView(R.layout.activity_main);//settings of design -DO NOT TOUCH


        Button button = (Button) findViewById(R.id.button);

        View.OnClickListener myHandler=new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Building Your Calendar", Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(MainList_1.this,EditEventActivity_2.class);
                startActivity(myIntent);
            }
        };
        button.setOnClickListener(myHandler);
    }



}


