package edu.javacourse.third.db;

import edu.javacourse.third.domain.PersonAdult;
import edu.javacourse.third.domain.PersonChild;
import edu.javacourse.third.domain.StudentOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonsaburov on 06.03.17.
 */
public class GetterForStudentOrder
{
    private static final int CHILD_COUNT = 2;

    public static List<StudentOrder> getStudentOrderList() {
        List<StudentOrder> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(getStudentOrder("Husband " + i, "Wife " + i, "Child"));
        }

        return result;
    }

    private static StudentOrder getStudentOrder(String hName, String wName, String cName) {
        PersonAdult h = new PersonAdult();
        h.setGivenName(hName);
        PersonAdult w = new PersonAdult();
        w.setGivenName(wName);
        List<PersonChild> children = new ArrayList<>();
        for (int i = 0; i < CHILD_COUNT; i++) {
            PersonChild c = new PersonChild();
            c.setGivenName(cName + " " + i);
            children.add(c);
        }

//        StudentOrder so = new StudentOrder(h, w, children);
        StudentOrder so = new StudentOrder();

        return so;
    }

}
