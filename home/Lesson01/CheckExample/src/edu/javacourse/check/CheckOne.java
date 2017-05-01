package edu.javacourse.check;

public class CheckOne
{

    public static void main(String[] args) {
        CheckOne co = new CheckOne();

        // Все строки ниже - это вызовы функций для тестов
        // Попробуйте без запуска понять результат выполнения
        // каждой функции
        co.test01();
        co.test02();
        co.test03();
        co.test04();
        co.test05();
    }

    void test01() {
        int a = 4;
        int b = 5;
        int c = 6;

        int d = a++ - --b + c;
        System.out.println(a + "," + b + "," + c + "," + d);
    }

    void test02() {
        int a = 4;
        int b = 5;
        int c = 6;

        int d = a++ / 2 - b % 3 + --c;
        System.out.println(a + "," + b + "," + c + "," + d);
    }

    void test03() {
        int a = 4;
        int b = 6;

        int c = a % b;
        System.out.println(a + "," + b + "," + c);
    }

    void test04() {
        int a = 4;
        int b = 5;
        int c = 6;

        int d = a % c - 8 + ++b / 2;
        System.out.println(a + "," + b + "," + c + "," + d);
    }

    void test05() {
        int a = 4;
        int b = 5;
        int c = 6;

        int d = -++a - ++c / 3 + b++ * 2;
        System.out.println(a + "," + b + "," + c + "," + d);
    }
}
