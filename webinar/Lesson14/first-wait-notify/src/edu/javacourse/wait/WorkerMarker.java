package edu.javacourse.wait;

/**
 * Created by antonsaburov on 27.04.17.
 */
public class WorkerMarker
{
    public synchronized void working() {
        System.out.println("First part is done");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Second part is done");
    }

    public synchronized void go() {
        notifyAll();
        System.out.println("Go 1");
        try {
            Thread.sleep(1000);
            System.out.println("Go 2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
