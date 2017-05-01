package edu.javacourse.pc;

/**
 * Created by antonsaburov on 27.04.17.
 */
public class Producer implements Runnable
{
    private Basket basket;

    public Producer(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        for (int i = 0; i < Starter.COUNT; i++) {
            basket.put((i + 1) * 10);
            try {
                Thread.sleep(Math.round(Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}
