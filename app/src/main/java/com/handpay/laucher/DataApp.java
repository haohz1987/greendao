package com.handpay.laucher;

import android.app.Application;

import com.handpay.laucher.db.DbCore;

/**
 * Created by haohz on 2018/1/26.
 */

public class DataApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        DbCore.init(this);
    }
}
