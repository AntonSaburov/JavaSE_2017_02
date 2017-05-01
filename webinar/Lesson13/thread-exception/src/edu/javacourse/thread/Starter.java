package edu.javacourse.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by antonsaburov on 24.04.17.
 */
public class Starter
{
    public static void main(String[] args) throws InterruptedException {
//        testOld();
        testNew();
        Thread.sleep(500);
        System.out.println("FINISH Global");
    }

    private static void testOld() {
        Thread t = new Thread(new SimpleRunnable01());

        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getState() + ":" + e.getMessage());
            }
        });
        t.start();
    }

    private static void testNew() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<?> submit = es.submit(new SimpleRunnable01());
        try {
            submit.get();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

//        es.shutdownNow();
        es.shutdown();
    }
}
