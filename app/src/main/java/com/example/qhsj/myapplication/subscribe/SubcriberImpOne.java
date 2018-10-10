package com.example.qhsj.myapplication.subscribe;

import android.util.Log;

/**
 * 订阅者实现类
 */
public class SubcriberImpOne<M> implements ISubcriber<M> {
    // 这个name是故意取来命名订阅者的，没有特殊的意义
    public String name;

    public SubcriberImpOne(String name) {
        super();
        this.name = name;
    }

    public void subcribe(SubscribePublish subscribePublish) {
        subscribePublish.subcribe(this);
    }

    public void unSubcribe(SubscribePublish subscribePublish) {
        subscribePublish.unSubcribe(this);
    }

    public void update(String publisher, M message) {
        Log.e("chris", this.name + "收到" + publisher + "发来的消息:" + message.toString());
    }
}
