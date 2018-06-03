package com.example.noy.myapplication;

import android.os.Bundle;

import java.util.Calendar;
import java.util.Date;

public class CalendarEvent extends Object{

    private Calendar date;
    private String description;
    private String category;

    // A normal parametrized constructor
    public CalendarEvent(Calendar date1, String description1, String category) {

        this.date = date1;
        this.description = description1;
        this.category = category;
    }

    public void set_date(Calendar date){
        this.date = date;
    }

    public void set_description(String description){
        this.description = description;
    }

    public void set_category(String category){
        this.category = category;
    }

    public String get_description(){
        return this.description;
    }







}