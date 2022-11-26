package com.example.myflux.reactivestreams;

import java.util.Arrays;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class MyPublisher implements Publisher<Integer> {

    Iterable<Integer> its = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        System.out.println("1. 구독자: 구독할게.");
        System.out.println("2. 오키 구독 정보를 만들어서 줄테니 기다려");
        MySubscription mySubscription = new MySubscription(subscriber, its);
        System.out.println("구독 정보 생성 완료");
        subscriber.onSubscribe(mySubscription);
    }
}
