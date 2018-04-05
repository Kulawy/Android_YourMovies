package com.pwr190729.jakubg.android_yourmovies;

import android.app.Application;
import android.content.Context;

/**
 * Created by JakubG on 05.04.2018.
 */

public class MyApplication extends Application{

    private static Context context;
    public void onCreate(){
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext(){
        return MyApplication.context;
    }

}
