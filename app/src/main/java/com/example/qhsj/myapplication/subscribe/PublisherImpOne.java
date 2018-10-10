package com.example.qhsj.myapplication.subscribe;

/**
 * 发布者实现类
 */
public class PublisherImpOne<M> implements IPublisher<M> {
     // 这个name是故意取来命名发布者的，没有特殊的意义
    private String name;

    public PublisherImpOne(String name) {
        super();
        this.name = name;
    }

    public void publish(SubscribePublish subscribePublish, M message, boolean isInstantMsg) {
        subscribePublish.publish(this.name, message, isInstantMsg);
    }
}
