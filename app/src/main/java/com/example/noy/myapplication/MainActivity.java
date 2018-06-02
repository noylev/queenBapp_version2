package com.example.noy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);

        View.OnClickListener myHandler=new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Building Your Calendar", Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(MainActivity.this,Main1Activity.class);
                startActivity(myIntent);
            }
        };
        button.setOnClickListener(myHandler);
    }
}


