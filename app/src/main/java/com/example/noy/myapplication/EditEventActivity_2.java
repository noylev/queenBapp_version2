package com.example.noy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;


public class EditEventActivity_2 extends AppCompatActivity {
    ClassicSingleton app_manager_memory = ClassicSingleton.getInstance();
    Vector<CalendarEvent> calendarEventsVector = app_manager_memory.getCalendarEvents();
    Calendar date = Calendar.getInstance();
    CalendarEvent calendar_event = new CalendarEvent(); //first initialize

    Button awesomeButton;
    CalendarView calendarView1;
    EditText event_desc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//settings of design -DO NOT TOUCH
        setContentView(R.layout.activity_main1); //settings of design -DO NOT TOUCH

        calendarEventsVector.add(calendar_event);
        event_desc = findViewById(R.id.event_name);
        final String[] arraySpinner = new String[] {
                "<none>", "Work", "Study", "Family", "Friends"
        };
        final Spinner spinner_category = findViewById(R.id.spinner_category);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_category.setAdapter(adapter);
        awesomeButton = findViewById(R.id.selectDate); //points to selectDate button
        awesomeButton.setOnClickListener(myhandler1);
        calendarView1 = findViewById(R.id.calendarView);//points to calendarView

        // this function saves the date it receives from the user
        calendarView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Toast.makeText(getBaseContext(),String.valueOf(year)+String.valueOf(month+1)+String.valueOf(dayOfMonth), Toast.LENGTH_LONG).show();
                date.set(year,month,dayOfMonth);

            }
        });



        Button moveToPage = (Button) findViewById(R.id.moveToPage);
        //this function is moving the user from this page(2) to page 3
        View.OnClickListener moveToPage3 =new View.OnClickListener(){
            public void onClick(View v) {

                calendar_event.set_description(event_desc.getText().toString());
                calendar_event.set_category(spinner_category.getSelectedItem().toString());
                calendar_event.set_date(date);
                app_manager_memory.getCalendarEvents().add(calendar_event);
                Toast.makeText(getBaseContext(), calendar_event.get_date().getTime().toString(), Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(EditEventActivity_2.this,ChooseHourActivity_3.class);
                myIntent.putExtra("EXTRA_SESSION_ID", calendar_event.get_description());
                startActivity(myIntent);
            }
        };
        moveToPage.setOnClickListener(moveToPage3);


    }
    //this function displays the calenderView on screen by clicking on button
    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            if (findViewById(R.id.calendarView).getVisibility() == View.INVISIBLE) {
                findViewById(R.id.calendarView).setVisibility(View.VISIBLE);
            } else {
                findViewById(R.id.calendarView).setVisibility(View.INVISIBLE);
            }

        }
    };



}




