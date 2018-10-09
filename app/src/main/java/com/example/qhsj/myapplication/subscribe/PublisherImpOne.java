package com.example.qhsj.myapplication.subscribe;

/**
 * 发布者实现类
 */
public class PublisherImpOne<M> implements IPublisher<M> {
    private String name;

    public PublisherImpOne(String name) {
        super();
        this.name = name;
    }

    public void publish(SubscribePublish subscribePublish, M message, boolean isInstantMsg) {
        subscribePublish.publish(this.name, message, isInstantMsg);
    }
}
