package edu.javacourse.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonsaburov on 20.04.17.
 */
public class Starter
{
    public static void main(String[] args) throws InterruptedException {
        List<MyThread> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MyThread mt = new MyThread("Name:" + i);
            mt.start();
            list.add(mt);
        }
        System.out.println("Started");

        Thread.sleep(5000);
        for(MyThread mt : list) {
            mt.stopThread();
        }

        annonExample();
    }

    private static void annonExample() {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("Annonymous");
            }
        };
        t.start();
        System.out.println(t.getClass().getCanonicalName());
    }
}
