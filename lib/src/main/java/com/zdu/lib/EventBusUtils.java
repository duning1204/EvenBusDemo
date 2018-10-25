package com.zdu.lib;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

/**
 * @author : 杜宗宁
 * @date : 2018/8/31
 * EventBus工具类
 */
public class EventBusUtils {

    public static void init(SubscriberInfoIndex subscriberInfoIndex) {
        EventBus.builder().addIndex(subscriberInfoIndex).installDefaultEventBus();
    }

    /**
     * 注册方法
     * 若注册的act没有@Subscribe注解，会抛异常
     */
    public static void register(Object subscriber) {
        if (!EventBus.getDefault().isRegistered(subscriber)) {
            try {
                EventBus.getDefault().register(subscriber);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 接触注册
     */
    public static void unregister(Object subscriber) {
        if (EventBus.getDefault().isRegistered(subscriber)) {
            try {
                EventBus.getDefault().unregister(subscriber);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送即时事件
     */
    public static void event(BaseEventBusBean bean) {
        EventBus.getDefault().post(bean);
    }

    /**
     * 发送粘性事件
     */
    public static void eventSticky(BaseEventBusBean bean) {
        EventBus.getDefault().postSticky(bean);
    }

    /**
     * 移除所以粘性事件
     */
    public static void removeAllStickyEvent() {
        EventBus.getDefault().removeAllStickyEvents();
    }

    /**
     * 移除一个粘性事件
     */
    public static boolean removeStickyEvent(BaseEventBusBean bean) {
        return EventBus.getDefault().removeStickyEvent(bean);
    }

    /**
     * 移除一个指定类型的粘性事件
     */
    public static <T> T removeClassStickyEvent(Class<T> clazz) {
        return EventBus.getDefault().removeStickyEvent(clazz);
    }

    /**
     * 优先级高的订阅者可以终止事件往下传递
     */
    public static void cancelEventDelivery(BaseEventBusBean bean) {
        try {
            EventBus.getDefault().cancelEventDelivery(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 清空缓存
     */
    public static void clearCache() {
        EventBus.clearCaches();
        
    }

}
