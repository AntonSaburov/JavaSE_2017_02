package edu.javacourse.pc;

/**
 * Created by antonsaburov on 27.04.17.
 */
public class Consumer implements Runnable
{
    private Basket basket;

    public Consumer(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        for (int i = 0; i < Starter.COUNT; i++) {
            int g = basket.get();
            try {
                Thread.sleep(Math.round(Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}
