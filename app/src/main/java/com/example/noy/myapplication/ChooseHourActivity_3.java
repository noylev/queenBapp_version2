package com.example.noy.myapplication;


import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;


public class ChooseHourActivity_3 extends AppCompatActivity {
    ClassicSingleton app_manager_memory = ClassicSingleton.getInstance();
    Vector<CalendarEvent> calendarEventsVector = app_manager_memory.getCalendarEvents();
    CalendarEvent calendar_event;
    TimePicker timepicker;
    int event_hour;
    int event_minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//settings of design -DO NOT TOUCH
        setContentView(R.layout.activity_main2);//settings of design -DO NOT TOUCH
        timepicker=findViewById(R.id.timePicker1);
        final String desc = getIntent().getStringExtra("EXTRA_SESSION_ID");

        findViewById(R.id.done_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), desc, Toast.LENGTH_LONG).show();
               calendar_event = app_manager_memory.find_event_by_desc(desc);
               if(calendar_event == null){
                    Log.i("find_event_by_desc" ,"NULL error - EVENT WAS NOT FOUND IN MEMORY!!!!!");
                }
                else{
                    //Toast.makeText(getBaseContext(), "function working good", Toast.LENGTH_LONG).show();
                    calendar_event.get_date().set(Calendar.HOUR,event_hour);
                    calendar_event.get_date().set(Calendar.MINUTE, event_minute);
                   Intent myIntent1 = new Intent(ChooseHourActivity_3.this,ListViewLoader.class);
                   startActivity(myIntent1);
               }

                /*Gson gson = new Gson();
                String json = gson.toJson(calendar_event);
                editor.putString(calendar_event.get_description(), json);
                editor.commit();*/

            }
        });


        timepicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
           @Override
           public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
               Toast.makeText(getBaseContext(), "hour is : "+String.valueOf(hourOfDay)+":"+String.valueOf(minute), Toast.LENGTH_LONG).show();
               event_hour = hourOfDay;
               event_minute = minute;
           }
       });


    }


}
