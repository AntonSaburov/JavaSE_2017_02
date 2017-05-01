package edu.javacourse.thread;

/**
 * Created by antonsaburov on 24.04.17.
 */
public class Starter
{
    public static void main(String[] args) {
        LocalExample le = new LocalExample();
        for(int i=0; i<10; i++) {
            new Thread(le).start();
        }
    }
}
