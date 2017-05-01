package edu.javacourse.wait;

/**
 * Created by antonsaburov on 27.04.17.
 */
public class Worker implements Runnable
{
    private volatile boolean goOn = false;

    public void setGoOn() {
        goOn = true;
    }
    @Override
    public void run() {
        System.out.println("First part is done");
        while(!goOn) {
        }
        System.out.println("Second part is done");
    }
}
