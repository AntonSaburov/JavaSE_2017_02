package edu.javacourse.wait;

/**
 * Created by antonsaburov on 27.04.17.
 */
public class Worker implements Runnable
{
    private WorkerMarker marker;

    public Worker(WorkerMarker marker) {
        this.marker = marker;
    }

    @Override
    public void run() {
        marker.working();
    }
}
