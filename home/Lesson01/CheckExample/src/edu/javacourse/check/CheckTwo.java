package edu.javacourse.check;

public class CheckTwo
{

    public static void main(String[] args) {
        CheckTwo ct = new CheckTwo();

        // Все строки ниже - это вызовы функций для тестов
        // Попробуйте без запуска понять результат выполнения
        // каждой функции
        ct.test01();
        ct.test02();
        ct.test03();
        ct.test04();
        ct.test05();
        ct.test06();
        ct.test07();
        ct.test08();
    }

    void test01() {
        for (int i = 0; i < 10; i++) {
            System.out.print("*");
        }
        System.out.println("!");
    }

    void test02() {
        int i = 0;
        while (i < 100) {
            System.out.print("+");
            if (i % 10 == 9) {
                System.out.println();
            }
            i++;
        }
        System.out.println();
    }

    void test03() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void test04() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void test05() {
        int i = 0;
        while (i < 10) {
            for (int j = 0; j < 10; j++) {
                if (j >= 9 - i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            i++;
        }
    }

    void test06() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j < i) {
                    System.out.print(" ");
                    continue;
                }
                if (j == i) {
                    System.out.print("*");
                    break;
                }
            }
            System.out.println();
        }
    }

    void test07() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i + 10; j++) {
                if (j >= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    void test08() {
        int i = 1;
        do {
            int k = (i - 1) / 10;
            if ((i % 2 == 0 && k % 2 == 1) || (i % 2 == 1 && k % 2 == 0)) {
                System.out.print(" ");
            } else {
                System.out.print("*");
            }
            if (i % 10 == 0) {
                System.out.println();
            }
            i++;
        } while (i <= 100);
        System.out.println();
    }
}
