package fr.yrisch.astrobay.controller;

import android.app.Activity;
import android.content.SharedPreferences;

public class Citypreference {
    SharedPreferences prefs;

    public Citypreference(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    // If the user has not chosen a city yet, return
    // Sydney as the default city
    String getCity(){
        return prefs.getString("city", "Grenoble, FR");
    }

    void setCity(String city){
        prefs.edit().putString("city", city).commit();
    }
}
