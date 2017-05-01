package edu.javacourse.first;

/**
 * Created by antonsaburov on 22.02.17.
 */
public class Second
{
    public static void main(String[] args) {

        for(int i=0; i<10; i++) {
            System.out.println("Hello " + i);
        }

        int i = 0;
        while (i < 10) {
            System.out.println("Hello " + i);
            i++;
        }

        i = 0;
        do {
            System.out.println("Hello " + i);
            i++;
        } while(i<10);

        if(getFirst() & getSecond() & getSecond()) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }

        int t = 6;
        switch(t) {
            case 1: {
                System.out.println("One"); break;
            }
            case 2: {
                System.out.println("Two"); break;
            }
            case 3: {
                System.out.println("Three"); break;
            }
            case 4:
            case 5: {
                System.out.println("Four Five"); break;
            }
            default: {
                System.out.println("Other"); break;
            }
            case 10: {
                System.out.println("Ten"); break;
            }
        }

        for(int j=0; j<10; j++) {
            if(j==3) {
                continue;
            }
            System.out.println("Hello " + j);
            if(j==5) {
                break;
            }
        }
    }

    static boolean getFirst() {
        System.out.println("First is called");
        return false;
    }

    static boolean getSecond() {
        System.out.println("Second is called");
        return true;
    }
}
