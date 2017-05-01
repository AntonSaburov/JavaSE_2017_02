package edu.javacourse.synch;

/**
 * Created by antonsaburov on 24.04.17.
 */
public class ListThread implements Runnable
{
    private CommonClass cc;

    public ListThread(CommonClass cc) {
        this.cc = cc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            cc.addItem(Math.round(Math.random() * 100) + "");
        }
    }
}
