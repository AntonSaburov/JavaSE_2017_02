package edu.javacourse.third.domain;

/**
 * Created by antonsaburov on 27.02.17.
 */
public class StudentOrder
{
    private Person husband;
    private Person wife;
    private Person child;

    public StudentOrder(Person husband, Person wife, Person child) {
        this.husband = husband;
        this.wife = wife;
        this.child = child;
    }

    public Person getHusband() {
        return husband;
    }

    public Person getWife() {
        return wife;
    }

    public Person getChild() {
        return child;
    }
}
