package com.example.noy.myapplication;

import java.util.Iterator;
import java.util.Vector;


public class ClassicSingleton{

    private Vector<CalendarEvent> calendarEvents = new Vector<CalendarEvent>();
    private static ClassicSingleton instance = null;

   /* private SharedPreferences sharedPreferences;
    private Editor editor = sharedPreferences.edit();
    private static String PREF_NAME = "prefs";
*/
    private ClassicSingleton() {
        // initialization code..

    }

    public static ClassicSingleton getInstance() {
        if(instance == null) {
            instance = new ClassicSingleton();
        }
        return instance;
    }

    public Vector<CalendarEvent> getCalendarEvents(){
        return calendarEvents;
    }

    public CalendarEvent find_event_by_desc(String description){
        CalendarEvent event = null;
        boolean found = false;
        Iterator iterator = this.calendarEvents.iterator();
        while(iterator.hasNext()&&!found){
            event = (CalendarEvent)iterator.next();
            if(event.get_description() == description)
                found= true;
        }
        return event;
    }



    //////////////////////shared preferenes////
/*
    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public CalendarEvent getEvent(Context context, String description) {
        Gson gson = new Gson();
        String json = getPrefs(context).getString(description, "");
        CalendarEvent calendarEvent1 = gson.fromJson(json, CalendarEvent.class);

        return calendarEvent1;
    }

    public void setEvent(CalendarEvent calendarEvent1) {

        Gson gson = new Gson();
        String json = gson.toJson(calendarEvent1);
        editor.putString(calendarEvent1.get_description(), json);
        editor.commit();
    }
*/

}