package com.example.noy.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class ListViewLoader extends AppCompatActivity  {
    ClassicSingleton app_manager_memory = ClassicSingleton.getInstance();
    Vector<CalendarEvent> calendarEventsVector = app_manager_memory.getCalendarEvents();
   // protected Button button;
    protected ArrayList<String> stringArrayListWork;
    protected ListView workListView;
    protected ListView studyListView;
    protected ListView familyListView;
    protected ArrayAdapter<String> stringArrayAdapter;
    Button clearAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_loader);
        workListView = findViewById(R.id.workListView);
        studyListView = findViewById(R.id.studyListView);
        familyListView = findViewById(R.id.familyListView);
        clearAll = findViewById(R.id.clearAll);
        clearAll.setOnClickListener(myhandler1);

        //these code lines adds a title to the list
        TextView textViewWork = new TextView(getApplicationContext());
        textViewWork.setText("Work Events");
        workListView.addHeaderView(textViewWork);


        TextView textViewStudy = new TextView(getApplicationContext());
        textViewStudy.setText("Study Events");
        studyListView.addHeaderView(textViewStudy);

        TextView textViewFamily = new TextView(getApplicationContext());
        textViewFamily.setText("Family Events");
        familyListView.addHeaderView(textViewFamily);

        //

        stringArrayListWork = new ArrayList<String>();
        int index = 0;
        String eventDesc = "";
        while ((eventDesc = getFromPreferences("" + index)) != null){
            stringArrayListWork.add(eventDesc);
            index++;
        }
        Iterator iterator = calendarEventsVector.iterator();
        if(calendarEventsVector!=null) {
            while (iterator.hasNext()) {
                CalendarEvent event = (CalendarEvent) iterator.next();
                if(event.get_category() == "Work") {
                    stringArrayListWork.add(event.get_description());
                }
            }
        }
        stringArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,stringArrayListWork);

        workListView.setAdapter(stringArrayAdapter);

        for (int i=0; i<stringArrayListWork.size(); i++){
            saveToPreferences(stringArrayListWork.get(i), "" + i);
        }
    }

    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            delteAllPreferences();
        }
    };
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

   private void delteAllPreferences() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        //String defaultString = null;
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.commit();
    }
}
