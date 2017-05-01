package edu.javacourse.thread;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by antonsaburov on 24.04.17.
 */
public class LocalExample implements Runnable
{
    private ThreadLocal<Counter> localCounter = new ThreadLocal<Counter>() {
        @Override
        protected Counter initialValue() {
            return new Counter();
        }
    };

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            localCounter.get().increase();
        }
    }

    public Long getCounter() {
        return localCounter.get().getCounter();
    }
}
