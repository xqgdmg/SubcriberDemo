package com.example.qhsj.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.qhsj.myapplication.subscribe.IPublisher;
import com.example.qhsj.myapplication.subscribe.ISubcriber;
import com.example.qhsj.myapplication.subscribe.PublisherImpOne;
import com.example.qhsj.myapplication.subscribe.SubcriberImpOne;
import com.example.qhsj.myapplication.subscribe.SubscribePublish;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 订阅者模式
                testSubscribe();
            }
        });

    }

    /*
     * 订阅者模式测试代码
     */
    private void testSubscribe() {
        SubscribePublish<String> subscribePublish = new SubscribePublish<String>("订阅器");
        IPublisher<String> publisher1 = new PublisherImpOne<String>("发布者1");
        ISubcriber<String> subcriber1 = new SubcriberImpOne<String>("订阅者1");
        ISubcriber<String> subcriber2 = new SubcriberImpOne<String>("订阅者2");
        subcriber1.subcribe(subscribePublish);
        subcriber2.subcribe(subscribePublish);
        publisher1.publish(subscribePublish, "welcome",true);
        publisher1.publish(subscribePublish, "to",true);
        publisher1.publish(subscribePublish, "yy",false);
    }


}
