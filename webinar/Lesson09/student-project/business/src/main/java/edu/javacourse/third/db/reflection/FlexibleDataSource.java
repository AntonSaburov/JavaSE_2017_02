package edu.javacourse.third.db.reflection;

import edu.javacourse.third.domain.StudentOrder;

import java.util.Collections;
import java.util.List;

/**
 * Created by antonsaburov on 23.03.17.
 */
public class FlexibleDataSource
{
    private String name;

    public FlexibleDataSource() {
    }

    public FlexibleDataSource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentOrder> getAllOrders() {
        System.out.println("getAllOrders");
        return Collections.EMPTY_LIST;
    }

    public List<StudentOrder> getAllOrders(int start, int size) {
        System.out.println("getAllOrders int int");
        return Collections.EMPTY_LIST;
    }

    @CallMe(comment = "Comment for CallMe")
    public void sayHello() {
        System.out.println("Very important method");
    }
}
