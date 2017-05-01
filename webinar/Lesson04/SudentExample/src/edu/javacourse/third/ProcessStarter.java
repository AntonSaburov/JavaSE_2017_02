package edu.javacourse.third;

import edu.javacourse.third.checkers.BasicChecker;
import edu.javacourse.third.checkers.GrnChecker;
import edu.javacourse.third.checkers.StudentChecker;
import edu.javacourse.third.checkers.ZagsChecker;
import edu.javacourse.third.db.GetterForStudentOrder;
import edu.javacourse.third.domain.Person;
import edu.javacourse.third.domain.PersonAdult;
import edu.javacourse.third.domain.PersonChild;
import edu.javacourse.third.domain.StudentOrder;

import java.util.Iterator;
import java.util.List;

/**
 * Created by antonsaburov on 22.02.17.
 */
public class ProcessStarter
{
    public static void main(String[] args) {
        ProcessStarter t = new ProcessStarter();
        t.processList();
    }

    void processList() {
        List<StudentOrder> orderList = GetterForStudentOrder.getStudentOrderList();

//        Iterator<StudentOrder> iter = orderList.iterator();
//        while(iter.hasNext()) {
//            StudentOrder so = iter.next();
//            processStudentOrder(so);
//        }
//        for(Iterator<StudentOrder> iter = orderList.iterator(); iter.hasNext(); ) {
//            processStudentOrder(iter.next());
//        }

        for(StudentOrder so : orderList) {
            processStudentOrder(so);
        }
    }

    void processStudentOrder(StudentOrder so) {
        boolean result = checkGrn(so);
        if(!result) {
            return;
        }
        result = checkZags(so);
        if(!result) {
            return;
        }
        result = checkStudent(so);
        if(!result) {
            return;
        }

        ApproveManager am = new ApproveManager();
        am.approveOrder(so);
    }


    private boolean checkGrn(StudentOrder so) {
        GrnChecker grn = new GrnChecker("1", 2, "3", "4");
        grn.setPerson(so.getHusband());
        if(!grn.check()) {
            return false;
        }
        grn.setPerson(so.getWife());
        if(!grn.check()) {
            return false;
        }
        grn.setPerson(so.getChild());
        if(!grn.check()) {
            return false;
        }
        return true;

//        if(grn.checkGRN(so.getHusband())
//                && grn.checkGRN(so.getWife()) && grn.checkGRN(so.getChild())) {
//            return true;
//        }
    }

    private boolean checkZags(StudentOrder so) {
        ZagsChecker zc = new ZagsChecker("1", 2, "3", "4");
        zc.setParameters(so.getHusband(), so.getWife(), null);
        if(!zc.check()) {
            return false;
        }
        zc.setParameters(so.getHusband(), so.getWife(), so.getChild());
        if(!zc.check()) {
            return false;
        }
        return true;
    }

    private boolean checkStudent(StudentOrder so) {
        StudentChecker sc = new StudentChecker("1", 2, "3", "4");
        sc.setPerson(so.getHusband());
        if(!sc.check()) {
            return false;
        }
        sc.setPerson(so.getWife());
        if(!sc.check()) {
            return false;
        }
        return true;
    }

}
