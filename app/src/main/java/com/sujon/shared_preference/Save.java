package com.sujon.shared_preference;

import android.content.Context;
import android.content.SharedPreferences;

public class Save {
    public static Save instance;

    String sharedPrefFileName = "com.sujon.shared_preference";
    Context context;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public Save(Context context) {
        this.context = context;
        preferences=context.getSharedPreferences(sharedPrefFileName,Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public static Save getInstance(Context context){
        if (instance==null) {
            instance = new Save(context);
        }
        return  instance;
    }

    public void saveString(String name, String value){
        editor.putString(name,value);
        editor.apply();

    }

    public String getSavedString(String name){
        return preferences.getString(name,null);

    }

    public void saveBoolean (String name, boolean value){
        editor.putBoolean(name,value);
        editor.apply();
    }

    public boolean getSaveBoolean (String name){
       return preferences.getBoolean(name,false);

    }

    public void saveInteger(String name, int value){
        editor.putInt(name, value);
        editor.apply();
    }
    public int getsaveInteger(String name){
        return preferences.getInt(name,0);
    }

}
