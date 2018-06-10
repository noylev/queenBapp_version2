package com.example.noy.myapplication;

import android.os.Bundle;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarEvent extends Object{

    private Calendar date = Calendar.getInstance();
    private String description;
    private String category;

    //SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    //String formatted = format1.format(date.getTime());


    public CalendarEvent() {

        this.date = Calendar.getInstance();
        this.description = null;
        this.category = null;
    }

    // A normal parametrized constructor
    public CalendarEvent(Calendar date1, String description1, String category) {

        this.date = date1;
        this.description = description1;
        this.category = category;
    }

    public void set_date(Calendar date){
        this.date = date;
        //this.date.set(1991,11,17,15,45);
    }

    public void set_description(String description){
        this.description = description;
    }

    public void set_category(String category){
        this.category = category;
    }

    public Calendar get_date(){
        return this.date;
    }
    public String get_description(){
        return this.description;
    }

    public String get_category(){
        return this.category;
    }







}