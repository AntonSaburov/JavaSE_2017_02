package edu.javacourse.thread;

/**
 * Created by antonsaburov on 24.04.17.
 */
public class Counter
{
    private Long counter = new Long(0);

    public void increase() {
        counter += Math.round(Math.random()*100);
    }

    public Long getCounter() {
        return counter;
    }
}
