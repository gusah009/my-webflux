package com.example.myflux.reactivestreams;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySubscriber implements Subscriber<Integer> {

    Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("구독자: 구독 정보 잘 받았어");
        this.subscription = subscription;
        System.out.println("구독자: 데이터 1개 줘");
        subscription.request(1); // 숫자 1개만큼 데이터를 받을게
        // 이걸 백프레셔라고 함. 소비자가 한번에 처리할 수 있는 개수를 요청함.
        // 소비자가 필요한 데이터를 요청하는 형식.
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("구독 데이터 " + item + " 전달");
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("구독 중 에러");
    }

    @Override
    public void onComplete() {
        System.out.println("구독 완료");
    }
}
