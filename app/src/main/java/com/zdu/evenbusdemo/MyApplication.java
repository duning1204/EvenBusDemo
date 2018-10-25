package com.zdu.evenbusdemo;

import android.app.Application;

import com.zdu.lib.EventBusUtils;

/**
 * @author : 杜宗宁
 * @date : 2018/10/17
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EventBusUtils.init(new MyEventBusIndex());
    }
}
