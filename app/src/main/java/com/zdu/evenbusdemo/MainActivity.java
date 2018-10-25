package com.zdu.evenbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zdu.lib.EventBusUtils;
import com.zdu.lib.bean.Demo3Bean;
import com.zdu.lib.bean.DemoBean;
import com.zdu.module1.EvenDemo;
import com.zdu.module2.EventDemo2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBusUtils.register(this);
        new EventDemo2().init();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, EvenDemo.class));
                Log.d("EvenDemo", "发送DemoBean");
                EventBusUtils.event(new DemoBean("sss"));
            }
        }, 3000);
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void Demo1(Demo2Bean bean) {
//        Log.d("EvenDemo", bean.ss);
//    }
}
