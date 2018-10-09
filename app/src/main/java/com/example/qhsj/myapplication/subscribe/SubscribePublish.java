package com.example.qhsj.myapplication.subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 订阅器类
 */
public class SubscribePublish<M> {
    //订阅器名称
    private String name;
    //订阅器队列容量
    final int QUEUE_CAPACITY = 20;
    //订阅器存储队列
    private BlockingQueue<Msg> queue = new ArrayBlockingQueue<Msg>(QUEUE_CAPACITY);
    //订阅者
    private List<ISubcriber> subcribers = new ArrayList<ISubcriber>();

    public SubscribePublish(String name) {
        this.name = name;
    }

    /**
     *  接收发布者的消息
     */
    public void publish(String publisher, M message, boolean isInstantMsg) {
        if (isInstantMsg) {
            update(publisher, message);
            return;
        }
        Msg<M> m = new Msg<M>(publisher, message);
        if (!queue.offer(m)) {
            update();
        }
    }

    /**
     *  订阅
     */
    public void subcribe(ISubcriber subcriber) {
        subcribers.add(subcriber);
    }

    /**
     *  退订
     */
    public void unSubcribe(ISubcriber subcriber) {
        subcribers.remove(subcriber);
    }

    /**
     *  发送存储队列所有消息
     */
    public void update() {
        Msg m = null;
        while ((m = queue.peek()) != null) {
            this.update(m.getPublisher(), (M) m.getMsg());
        }
    }

    /**
     *  发送消息
     */
    public void update(String publisher, M Msg) {
        for (ISubcriber subcriber : subcribers) {
            subcriber.update(publisher, Msg);
        }
    }
}

