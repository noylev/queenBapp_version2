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
import java.util.Vector;


public class EditEventActivity_2 extends AppCompatActivity {
    ClassicSingleton app_manager_memory = ClassicSingleton.getInstance();
    Vector<CalendarEvent> calendarEventsVector = app_manager_memory.getCalendarEvents();
    Calendar date = Calendar.getInstance();
    CalendarEvent calendar_event = new CalendarEvent(date, "","none"); //first initialize

    Button awesomeButton;
    CalendarView calendarView1;
    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
    String curDate = sdf.format(date.getTime());
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
        Spinner spinner_category = findViewById(R.id.spinner_category);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_category.setAdapter(adapter);
        awesomeButton = findViewById(R.id.selectDate); //points to selectDate button
        awesomeButton.setOnClickListener(myhandler1);
        calendarView1 = findViewById(R.id.calendarView);//points to calendarView






        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("category", (String) parent.getItemAtPosition(position));
                calendar_event.set_category( parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        // this function saves the date it receives from the user
        calendarView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                date.set(month, year, dayOfMonth ,0,0);
                //calendarView1.setVisibility(View.INVISIBLE);//once date is selected, set calendar to invisible
                //Intent myIntent = new Intent(EditEventActivity_2.this,ChooseHourActivity_3.class);
                //myIntent.putExtra("EXTRA_SESSION_ID", date); //passing the date that was picked to the next page
               // startActivity(myIntent);
            }
        });



        Button moveToPage = (Button) findViewById(R.id.moveToPage);
        //this function is moving the user from this page(2) to page 3
        View.OnClickListener moveToPage3 =new View.OnClickListener(){
            public void onClick(View v) {

                //calendar_event.set_description("noy");

                Intent myIntent = new Intent(EditEventActivity_2.this,ChooseHourActivity_3.class);
                Toast.makeText(getBaseContext(), event_desc.getText().toString(), Toast.LENGTH_LONG).show();
                //Toast.makeText(getBaseContext(), calendar_event.get_description(), Toast.LENGTH_LONG).show();
               // myIntent.putExtra("EXTRA_SESSION_ID", curDate); //passing the date that was picked to the next page
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




