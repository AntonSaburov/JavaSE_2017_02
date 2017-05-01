package edu.javacourse.base;

import java.util.Date;

/**
 * Created by antonsaburov on 06.03.17.
 */
public class Starter
{
    public final static String NAME = "1234567890";
    private final String name;

    public Starter() {
        this.name = "123234224243";
    }

    public static void main(String[] args) {
        Object obj = null;
        obj.equals(obj);
        obj.hashCode();

        Date d1 = new Date(99_000_000_000L);
        Date d2 = new Date(99_000_000_000L);

        if(d1.equals(d2)) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }

        SimpleClass c1 = new SimpleClass("12345");
        SimpleClass c2 = new SimpleClass("12345");

        if(c1.equals(c2)) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }

    }
}

