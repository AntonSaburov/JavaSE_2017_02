package edu.javacourse.first;

/**
 * Created by antonsaburov on 22.02.17.
 */
public class First
{
    public static void main(String[] args) {
//        byte b = 1;
//        short s = 2;
//        int a = 3;
//        long l = 4;
//        float f = 5.0f;
//        double d = 6.0;
//        char c ='\u1800';
//        char c1 = 'f';
//        boolean b1 = false;
//        boolean b2 = true;

        int a1 = 1, a2 = 2, a3 = 3, a4 = 4, a5 = 5;

        a1 = a2 + a3;
        System.out.println(a1);

        a1 = a1/2 + a5/2;
        System.out.println(a1);

        a1 = a1%2 + a5%2;
        System.out.println(a1);

        a1 = (a3++) + (++a4);
        //a1 = (3) + (5);
        System.out.println(a1 + "," + a3 + "," + a4);

        a1 = (--a4) + (--a5);
        System.out.println(a1 + "," + a4 + "," + a5);

    }
}
