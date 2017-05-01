package edu.javacourse.wait;

/**
 * Created by antonsaburov on 27.04.17.
 */
public class Starter
{
    public static void main(String[] args) throws InterruptedException {
        WorkerMarker wm = new WorkerMarker();
        for(int i=0; i<3; i++) {
            Worker w = new Worker(wm);
            new Thread(w).start();
        }

        Thread.sleep(2000);
        wm.go();
    }
}
