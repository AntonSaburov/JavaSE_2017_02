package edu.javacourse.third.db;

import edu.javacourse.third.domain.StudentOrder;

import java.util.List;

/**
 * Created by antonsaburov on 23.03.17.
 */
public interface StudentOrderDataSource
{
    Long addStudentOrder(StudentOrder so);
    List<StudentOrder> getStudentOrders();
}
