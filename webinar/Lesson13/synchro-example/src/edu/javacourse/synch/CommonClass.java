package edu.javacourse.synch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonsaburov on 24.04.17.
 */
public class CommonClass
{
    private List<String> list = new ArrayList<>(20000);

    private long test = 0;
    private double d = 0;
    private String g;

    public synchronized void addItem(String str) {
        list.add(str);
    }

    public synchronized int getSize() {
        return list.size();
    }

    public void setTest(int test) {
        this.test = test;
    }

    public void setG(String g) {
        this.g = g;
    }
}
