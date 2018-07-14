package com.yj.cardgame;

import android.app.Application;
import android.content.Context;

/**
 * Created by yangjie on 2018/7/14.
 */

public class APP extends Application {
    private static  Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
