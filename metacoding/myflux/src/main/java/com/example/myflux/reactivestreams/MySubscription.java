package com.example.myflux.reactivestreams;

import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

// 구독 정보 (구독자가 누구인지, 어떤 데이터를 구독할지)
public class MySubscription implements Subscription {

    private Subscriber<? super Integer> s;
    private Iterator<Integer> its;

    public MySubscription(Subscriber<? super Integer> s, Iterable<Integer> its) {
        this.s = s;
        this.its = its.iterator();
    }

    @Override
    public void request(long n) {
        while (n > 0) {
            if (its.hasNext()) {
                s.onNext(its.next());
            } else {
                s.onComplete();
                System.out.println("더 이상 보낼 데이터가 없어!");
                break;
            }
            n--;
        }
    }

    @Override
    public void cancel() {

    }
}
