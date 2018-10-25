package com.zdu.module2;

import android.util.Log;

import com.zdu.lib.EventBusUtils;
import com.zdu.lib.bean.Demo2Bean;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author : 杜宗宁
 * @date : 2018/10/25
 */
public class EventDemo2 {
    public void init(){
        EventBusUtils.register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void test1(Demo2Bean bean){
        Log.d("EvenDemo", "接收到Demo2Bean");
    }
}
