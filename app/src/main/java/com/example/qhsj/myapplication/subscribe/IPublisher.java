package com.example.qhsj.myapplication.subscribe;

/**
 * 发布者接口
 */
public interface IPublisher<M> {
    /**
     * 向订阅器发布消息
     */
    public void publish(SubscribePublish subscribePublish, M message, boolean isInstantMsg);
}
