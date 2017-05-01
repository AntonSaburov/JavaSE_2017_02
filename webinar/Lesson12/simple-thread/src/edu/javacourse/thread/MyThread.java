package edu.javacourse.thread;

/**
 * Created by antonsaburov on 20.04.17.
 */
public class MyThread extends Thread
{
    private String threadName;
    private volatile boolean running = true;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
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
