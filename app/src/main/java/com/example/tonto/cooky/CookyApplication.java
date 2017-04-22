package com.example.tonto.cooky;

import android.app.Application;

/**
 * Created by tonto on 4/22/2017.
 */

public class CookyApplication extends Application {
    private static CookyApplication instance;
    private CookyDatabase cookyDatabase;

    @Override
    public void onCreate() {
        cookyDatabase = new CookyDatabase(this);
        instance = this;
        super.onCreate();
    }

    public static CookyApplication getInstance() {
        return instance;
    }

    public CookyDatabase getCookyDatabase() {
        return cookyDatabase;
    }
}
