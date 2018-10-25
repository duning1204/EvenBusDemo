package com.zdu.evenbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zdu.lib.EventBusUtils;
import com.zdu.lib.bean.Demo3Bean;
import com.zdu.lib.bean.DemoBean;
import com.zdu.module1.EvenDemo;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("Main2Activity", "onCreate");
        EventBusUtils.register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main2Activity", "onResume");
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Demo(Demo3Bean bean) {
        Log.d("Main2Activity", "接收到粘性事件");
        startActivity(new Intent(Main2Activity.this, EvenDemo.class));
        EventBusUtils.event(new DemoBean("sss"));
    }
}
