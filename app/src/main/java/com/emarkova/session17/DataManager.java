package com.emarkova.session17;

import android.content.Context;
import android.content.SharedPreferences;

public class DataManager {
    private static final String NAME_PREF = "USER_PREF";
    public static final String KEY = "key";
    public static final String COUNTER = "counter";
    private Context context;

   public DataManager (Context context) {
       this.context = context;
   }

    public void setPref() {
        SharedPreferences preferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        if (!preferences.contains(COUNTER)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(COUNTER, 0);
            editor.apply();
        }
    }

    public void setUser(String str) {
        SharedPreferences preferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        int counter = preferences.getInt(COUNTER, 0) + 1;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(COUNTER, counter);
        editor.putString(KEY+counter, str);
        editor.apply();
    }

    public String getUser(int i) {
        SharedPreferences preferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        return preferences.getString(KEY+i, "");
    }

    public int getCounter() {
        SharedPreferences preferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        return preferences.getInt(COUNTER, 0);
    }

    public void deletePref() {
        SharedPreferences preferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.putInt(COUNTER, 0);
        editor.apply();
    }
}
