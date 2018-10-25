package com.zdu.module1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.zdu.lib.EventBusUtils;
import com.zdu.lib.bean.Demo2Bean;
import com.zdu.lib.bean.DemoBean;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author : 杜宗宁
 * @date : 2018/8/30
 */
public class EvenDemo extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_layout);
        EventBusUtils.register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Demo(DemoBean bean){
        Log.d("EvenDemo","接收到DemoBean");
        Log.d("EvenDemo","发送Demo2Bean");
        EventBusUtils.event(new Demo2Bean("即时数据"));
    }

}
