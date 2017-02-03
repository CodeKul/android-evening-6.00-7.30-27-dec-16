package com.melayer.rxapp;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by aniruddha on 3/2/17.
 */

public class ObservableFactory {

    public static Observable<Integer> forLoop() {
        return Observable.<Integer>create( (ObservableOnSubscribe<Integer>)  emitter -> {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100);
                emitter.onNext(i);
            }
            emitter.onComplete();
        });
    }
}
