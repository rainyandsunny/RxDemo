package com.example.rainy.rxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  Observable<String> myObservable = rx.Observable.create(
                new Observable.OnSubscribe<String>(){

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello world");
                subscriber.onCompleted();
            }
        });*/

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("完成");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };
        Observable<String> myObservable = Observable.just("杨海鹏");
        Action1<String> onNextAction = new Action1<String>(){

            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };
       // myObservable.subscribe(mySubscriber);
        Action1<String> onComplete = new Action1<String>(){

            @Override
            public void call(String s) {
                System.out.println("完成");
            }
        };
        Action1<Throwable> onErrAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                System.out.println("出错");
            }
        };
        //myObservable.subscribe(onNextAction);
        myObservable.subscribe(onNextAction,onErrAction,onComplete);
    }
}
