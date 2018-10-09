package com.example.qhsj.myapplication.subscribe;

/**
 * @Description: 消息类
 */
class Msg<M>{
    private String publisher;
    private M m;
    public Msg(String publisher, M m) {
        this.publisher = publisher;
        this.m = m;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public M getMsg() {
        return m;
    }
    public void setMsg(M m) {
        this.m = m;
    }
}
