package com.example.noy.myapplication;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.SharedPreferences;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        int index = 0;
        String eventDesc = "";
        while ((eventDesc = getFromPreferences("" + index)) != null){
            stringArrayList.add(eventDesc);
            index++;
        }
        Iterator iterator = calendarEventsVector.iterator();
        if(calendarEventsVector!=null) {
            while (iterator.hasNext()) {
                CalendarEvent event = (CalendarEvent) iterator.next();
                stringArrayList.add(event.get_description());
            }
        }
        stringArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,stringArrayList);

        listView.setAdapter(stringArrayAdapter);

        for (int i=0; i<stringArrayList.size(); i++){
            saveToPreferences(stringArrayList.get(i), "" + i);
        }
    }

//    private void writeTOJson(){
//        GsonBuilder gsonb = new GsonBuilder();
//        Gson mGson = gsonb.create();
//        String writeValue = mGson.toJson(stringArrayList);
//        saveToPreferences(writeValue);
//        Log.e("NOYA", writeValue);
//    }

    private void saveToPreferences(String saveString, String key){
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, saveString);
        editor.commit();
    }

    private String getFromPreferences(String key) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String defaultString = null;
        String prefString = sharedPref.getString(key, defaultString);
        return prefString;
    }
}
