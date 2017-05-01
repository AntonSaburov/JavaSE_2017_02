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
import edu.javacourse.third.exception.CheckException;
import edu.javacourse.third.exception.ConnectException;
import edu.javacourse.third.exception.SendGetDataException;

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
        try {
            grn.setPerson(so.getHusband());
            if (!grn.check()) {
                return false;
            }
            grn.setPerson(so.getWife());
            if(!grn.check()) {
                return false;
            }
            for(PersonChild pc : so.getChildren()) {
                grn.setPerson(pc);
                if (!grn.check()) {
                    return false;
                }
            }
        } catch(CheckException ex) {
            ex.printStackTrace();
            return false;
        } catch(Exception ex) {
            return false;
        }

        return true;
    }

    private boolean checkZags(StudentOrder so) {
        ZagsChecker zc = new ZagsChecker("1", 2, "3", "4");
        zc.setParameters(so.getHusband(), so.getWife(), null);
//        if(!zc.check()) {
//            return false;
//        }
//        for(PersonChild pc : so.getChildren()) {
//            zc.setParameters(so.getHusband(), so.getWife(), pc);
//            if (!zc.check()) {
//                return false;
//            }
//        }
        return true;
    }

    private boolean checkStudent(StudentOrder so) {
        StudentChecker sc = new StudentChecker("1", 2, "3", "4");
        sc.setPerson(so.getHusband());
//        if(!sc.check()) {
//            return false;
//        }
//        sc.setPerson(so.getWife());
//        if(!sc.check()) {
//            return false;
//        }
        return true;
    }

}
