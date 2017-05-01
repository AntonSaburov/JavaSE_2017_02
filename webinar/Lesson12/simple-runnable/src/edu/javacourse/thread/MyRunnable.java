package edu.javacourse.thread;

/**
 * Created by antonsaburov on 20.04.17.
 */
public class MyRunnable implements Runnable
{
    private String threadName;
    private volatile boolean running = true;

    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while(running) {
            System.out.println("Hello:" + threadName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
