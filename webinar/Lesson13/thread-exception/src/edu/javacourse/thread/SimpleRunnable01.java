package edu.javacourse.thread;

/**
 * Created by antonsaburov on 24.04.17.
 */
public class SimpleRunnable01 implements Runnable
{
    @Override
    public void run() {
        System.out.println("Simple Runnable 01 - START");
        if(true) {
//            throw new RuntimeException("Exception 01");
        }
        System.out.println("Simple Runnable 01 - FINISH");
    }
}
