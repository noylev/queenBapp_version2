package com.example.noy.myapplication;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ListViewLoader extends AppCompatActivity  {
    ClassicSingleton app_manager_memory = ClassicSingleton.getInstance();
    Vector<CalendarEvent> calendarEventsVector = app_manager_memory.getCalendarEvents();
   // protected Button button;
    protected ArrayList<String> stringArrayList;
    protected ListView listView;
    protected ArrayAdapter<String> stringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_loader);
        listView = findViewById(R.id.listView);
        stringArrayList = new ArrayList<String>();
        Iterator iterator = calendarEventsVector.iterator();
        if(calendarEventsVector!=null) {
            Log.i("debug", "**********************************************");
            while (iterator.hasNext()) {
                CalendarEvent event = (CalendarEvent) iterator.next();
                stringArrayList.add(event.get_description());
                Log.i("iterator", event.get_description());
            }
        }
        stringArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,stringArrayList);
        listView.setAdapter(stringArrayAdapter);


        Log.i("noy", "enters iteration loopppppppp");


    }
}

