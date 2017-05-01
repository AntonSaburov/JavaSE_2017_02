package edu.javacourse.third;

import edu.javacourse.third.checkers.GrnChecker;
import edu.javacourse.third.checkers.GrnCheckerXml;
import edu.javacourse.third.domain.Person;
import edu.javacourse.third.domain.StudentOrder;

/**
 * Created by antonsaburov on 22.02.17.
 */
public class Third
{
    public static void main(String[] args) {
        Third t = new Third();
        t.testProcess();

    }

    void testProcess() {
        StudentOrder so = getStudentOrder();
//        System.out.println(so.husband.surName);
//        System.out.println(so.wife.surName);
//        System.out.println(so.child.surName);

        GrnCheckerXml grn = new GrnCheckerXml();
        grn.setIp("1");
        grn.setPort(2);
        grn.setLogin("3");
        grn.setPassword("4");

//        GrnChecker grn2 = new GrnChecker();
//        grn2.ip = "21";
//        grn2.port = 22;
//        grn2.login = "23";
//        grn2.password = "24";
//
//        grn.checkGRN(so.husband);
//        grn2.checkGRN(so.husband);

        if(!grn.checkGRN(so.getHusband())) {
            return;
        }
        if(!grn.checkGRN(so.getWife())) {
            return;
        }
        if(!grn.checkGRN(so.getChild())) {
            return;
        }
        if(!checkMaritalStatus(so.getHusband(), so.getWife())) {
            return;
        }
        if(!checkChild(so.getChild())) {
            return;
        }
        if(!checkStudent(so.getHusband())) {
            return;
        }
        if(!checkStudent(so.getWife())) {
            return;
        }

        approveOrder(so);
    }

    boolean checkMaritalStatus(Person husband, Person wife) {
        // Здесь проверим статус - муж и жена
        return true;
    }

    boolean checkChild(Person child) {
        return true;
    }

    boolean checkStudent(Person student) {
        return true;
    }

    void approveOrder(StudentOrder so) {

    }

    StudentOrder getStudentOrder() {
        Person h = new Person();
        h.setGivenName(new String("Мастер"));
        Person w = new Person();
        w.setGivenName("Маргарита");
        Person c = new Person();
        c.setGivenName("Михаил");

        StudentOrder so = new StudentOrder(h, w, c);

        return so;
    }
}
