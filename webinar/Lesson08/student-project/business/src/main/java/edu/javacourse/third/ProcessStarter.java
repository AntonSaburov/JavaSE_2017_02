package edu.javacourse.third;

import edu.javacourse.third.answer.CheckerAnswer;
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

import java.util.*;

/**
 * Created by antonsaburov on 22.02.17.
 */
public class ProcessStarter
{
    public static void main(String[] params) {
        ProcessStarter t = new ProcessStarter();
        t.processList();

    }

    public void processList() {
        List<StudentOrder> orderList = GetterForStudentOrder.getStudentOrderList();
        for (StudentOrder so : orderList) {
            processStudentOrder(so);
        }
    }

    private void processStudentOrder(StudentOrder so) {
        List<CheckerAnswer> answers = new ArrayList<>();

        try {
            answers.addAll(checkGrn(so));
            answers.addAll(checkZags(so));
            answers.addAll(checkStudent(so));
        } catch(CheckException ex) {
            // TODO Сделать обработку ошибки - что-то записать в базу
            return;
        }

        ApproveManager approveManager = new ApproveManager();
        for(CheckerAnswer ca : answers) {
            if(!ca.getResult()) {
                approveManager.denyOrder(so, answers);
                return;
            }
        }
        approveManager.approveOrder(so, answers);
    }

    private List<CheckerAnswer> checkGrn(StudentOrder so) throws CheckException {
        List<CheckerAnswer> answers = new ArrayList<>();
        GrnChecker grn = new GrnChecker("1", 2, "3", "4");
        grn.setPerson(so.getHusband());
        answers.add(grn.check());
        grn.setPerson(so.getWife());
        answers.add(grn.check());
        for (PersonChild pc : so.getChildren()) {
            grn.setPerson(pc);
            answers.add(grn.check());
        }
        return answers;
    }

    private List<CheckerAnswer> checkZags(StudentOrder so) throws CheckException {
        List<CheckerAnswer> answers = new ArrayList<>();
        ZagsChecker zc = new ZagsChecker("1", 2, "3", "4");
        zc.setParameters(so.getHusband(), so.getWife(), null);
        answers.add(zc.check());
        for (PersonChild pc : so.getChildren()) {
            zc.setParameters(so.getHusband(), so.getWife(), pc);
            answers.add(zc.check());
        }
        return answers;
    }

    private List<CheckerAnswer> checkStudent(StudentOrder so) throws CheckException {
        List<CheckerAnswer> answers = new ArrayList<>();
        StudentChecker sc = new StudentChecker("1", 2, "3", "4");
        sc.setPerson(so.getHusband());
        answers.add(sc.check());
        sc.setPerson(so.getWife());
        answers.add(sc.check());
        return answers;
    }
}
