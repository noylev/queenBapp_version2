package com.example.noy.myapplication;

import android.util.Log;
import android.widget.ListView;

import java.util.Iterator;
import java.util.Vector;

public class ClassicSingleton {

    private Vector<CalendarEvent> calendarEvents = new Vector<CalendarEvent>();

    private static ClassicSingleton instance = null;

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
        while(iterator.hasNext()||!found){
            event = (CalendarEvent)iterator.next();
            if(event.get_description() == description)
                found= true;
        }
        return event;
    }
}