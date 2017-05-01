package edu.javacourse.pc;

/**
 * Created by antonsaburov on 27.04.17.
 */
public class Starter
{
    public static final int COUNT = 5;

    public static void main(String[] args) {
        Basket b = new Basket();
        Producer p = new Producer(b);
        Consumer c = new Consumer(b);

        new Thread(c).start();
        new Thread(p).start();
    }
}
