package com.lonelypluto.loadresourcedemo.application;

import android.app.Application;

import com.lonelypluto.loadresourcedemo.utils.SharedPreferencesUtil;
import com.lonelypluto.loadresourcedemo.utils.LoadResourceUtil;

/**
 * @Description:
 * @author: ZhangYW
 * @time: 2018/9/5 9:30
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferencesUtil.init(this);
        LoadResourceUtil.getInstance().init(this, SharedPreferencesUtil.getResourcePath());
    }
}
