package com.example.noy.myapplication;

import java.util.Vector;

public class ClassicSingleton {

    private  Vector<CalendarEvent> calendarEvents = new Vector<CalendarEvent>();

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
}