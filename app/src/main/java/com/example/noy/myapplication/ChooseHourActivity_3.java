package com.example.noy.myapplication;


import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TimePicker;
import android.widget.Toast;


public class ChooseHourActivity_3 extends AppCompatActivity {
    TimePicker timepicker1;
    // public String date_picked_by_user = getIntent().getStringExtra("EXTRA_SESSION_ID");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        timepicker1=findViewById(R.id.timePicker1);
        findViewById(R.id.done_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), getIntent().getStringExtra("EXTRA_SESSION_ID"), Toast.LENGTH_LONG).show();
            }
        });

    }
}
