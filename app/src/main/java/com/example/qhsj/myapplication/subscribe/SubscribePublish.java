package com.example.qhsj.myapplication.subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 订阅器类
 */
public class SubscribePublish<M> {
    //订阅器名称，无特殊的意义
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
        if (isInstantMsg) { // 即时更新消息，不存储 BlockingQueue
            update(publisher, message);
            return;
        }

         // 不是即时消息，存储到 BlockingQueue，如果BlockingQueue容量不足，发送存储队列所有消息
        Msg<M> m = new Msg<M>(publisher, message);
        if (!queue.offer(m)) { // offer 如果可以在不违反容量限制的情况下立即执行此操作，则将指定的元素插入此队列，true成功返回 并且false当前没有空间可用。
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
        while ((m = queue.peek()) != null) { // peek 取头部数据但不移除此队列的头部，如果此队列为空，则返回null。
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

