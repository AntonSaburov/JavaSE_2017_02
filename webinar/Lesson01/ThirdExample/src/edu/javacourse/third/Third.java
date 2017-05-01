package edu.javacourse.third;

/**
 * Created by antonsaburov on 22.02.17.
 */
public class Third
{
    public static void main(String[] args) {
        Third t = new Third();
        t.testProcess();

        int t1 = 99 & 101;
    }

    void testProcess() {
        Person husband = null;
        Person wife = null;
        Person child = null;

        boolean result = checkGRN(husband);
        if(!result) {
            return;
        }
        checkGRN(wife);
        checkGRN(child);

        int a = sum(99, 12);
        System.out.println(a);
    }

    boolean checkGRN(Person p) {
        // Она тут много чего интересного делает
        return false;
    }

    int test() {
        int t = 99;
        // много всяких вычислений
        return t;
    }

    int sum(int t1, int t2) {
        int s = t1 + t2;
        return s;
    }
}
