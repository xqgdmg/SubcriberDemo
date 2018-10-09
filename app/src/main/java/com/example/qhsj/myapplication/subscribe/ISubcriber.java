package com.example.qhsj.myapplication.subscribe;

/**
 * 订阅者接口
 */
public interface ISubcriber<M> {
    /**
     * 订阅
     */
    public void subcribe(SubscribePublish subscribePublish);

    /**
     * 退订
     */
    public void unSubcribe(SubscribePublish subscribePublish);

    /**
     * 接收消息
     */
    public void update(String publisher, M message);
}
