package edu.javacourse.pc;

/**
 * Created by antonsaburov on 27.04.17.
 */
public class Basket
{
    private int value;
    private boolean empty = true;

    public synchronized void put(int p) {
        while(!empty) {
            try {
                System.out.println("PUT is waiting");
                wait();
            } catch (InterruptedException e) {
            }
        }
        value = p;
        empty = false;
        notifyAll();
        System.out.println("PUT:" + value);
    }

    public synchronized int get() {
        while(empty) {
            try {
                System.out.println("GET is waiting");
                wait();
            } catch (InterruptedException e) {
            }
        }
        empty = true;
        notifyAll();
        System.out.println("GET:" + value);
        return value;
    }
}
