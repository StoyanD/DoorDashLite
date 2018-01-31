package com.stoyan.doordashlite.app;

import android.app.Application;

/**
 * Created by stoyan on 1/30/18.
 */
public class DoorDashApplication extends Application {
    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent =  DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
