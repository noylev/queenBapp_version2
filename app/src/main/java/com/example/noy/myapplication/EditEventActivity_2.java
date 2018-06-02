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
import android.widget.Spinner;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class EditEventActivity_2 extends AppCompatActivity {
    Button awesomeButton;
    CalendarView calendarView1;
    Calendar date = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
    String curDate = sdf.format(date.getTime());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1); //settings of design

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
        final CalendarEvent calendar_event = new CalendarEvent(date, "","none"); //first initialize





        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                calendar_event.set_category((String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        // this function saves the date it receives from the user
        /*calendarView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Toast.makeText(getBaseContext(), "button pressed7", Toast.LENGTH_SHORT).show();
                int d = dayOfMonth;
                curDate = String.valueOf(d) + String.valueOf(month) + String.valueOf(year);
                Toast.makeText(getBaseContext(), "date is : " + curDate, Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), ""+dayOfMonth, Toast.LENGTH_SHORT).show();// TODO Auto-generated method stub
                calendarView1.setVisibility(View.INVISIBLE);//once date is selected, set calendar to invisible
                //timepicker1.setVisibility(View.VISIBLE); //once date is selected, set time-picker to visible
                Intent myIntent = new Intent(EditEventActivity_2.this,ChooseHourActivity_3.class);
                startActivity(myIntent);
            }
        });*/



        // this function saves the date it receives from the user
        calendarView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {

                Toast.makeText(getBaseContext(), "button pressed7", Toast.LENGTH_SHORT).show();
                date.set(month, year, dayOfMonth ,0,00);
                Toast.makeText(getBaseContext(), "date is : " + date.toString(), Toast.LENGTH_LONG).show();
                calendarView1.setVisibility(View.INVISIBLE);//once date is selected, set calendar to invisible
                Intent myIntent = new Intent(EditEventActivity_2.this,ChooseHourActivity_3.class);
                myIntent.putExtra("EXTRA_SESSION_ID", date); //passing the date that was picked to the next page
                startActivity(myIntent);
            }
        });





        //Toast.makeText(getBaseContext(), "date is lala : " + curDate, Toast.LENGTH_LONG).show();

        Button moveToPage = (Button) findViewById(R.id.moveToPage);
        //this function is moving the user from this page(2) to page 3
        View.OnClickListener moveToPage3 =new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Your Agenda", Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(EditEventActivity_2.this,ChooseHourActivity_3.class);
                myIntent.putExtra("EXTRA_SESSION_ID", curDate); //passing the date that was picked to the next page
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
            Toast.makeText(getBaseContext(), "button pressed", Toast.LENGTH_SHORT).show();
        }
    };



}




