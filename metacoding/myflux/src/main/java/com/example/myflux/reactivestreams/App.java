package com.example.myflux.reactivestreams;

public class App {

    public static void main(String[] args) {
        MyPublisher pub = new MyPublisher();
        MySubscriber sub = new MySubscriber();

        pub.subscribe(sub);
    }

}
