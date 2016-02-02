package com.sourceit.task1;

import android.app.Application;

import com.sourceit.task1.utils.Toasts;

/**
 * Created by User on 31.01.2016.
 */
public class App extends Application {
    private static App instance;

    public static App getApp() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Toasts.init(this);
    }
}
