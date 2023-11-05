package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumberMono().subscribe(System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Mono Every thing is OK!"));

        Disposable subscribe = ReactiveSources.intNumbersFlux().subscribe(System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Flux Every thing is OK!"));

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }
}

// we nned this when we have to add a data receiving control
class MySubscriber<T> extends BaseSubscriber<T> {
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscription happenend");
        // send one result
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        // asking for one more
        request(1);
    }
}