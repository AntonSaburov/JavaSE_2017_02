package edu.javacourse.third.checkers;

import edu.javacourse.third.answer.CheckerAnswer;
import edu.javacourse.third.checkers.answer.BasicCheckerAnswer;
import edu.javacourse.third.domain.Person;
import edu.javacourse.third.exception.SendGetDataException;

/**
 * Created by antonsaburov on 02.03.17.
 */
public class ZagsChecker extends BasicChecker
{
    private Person husband;
    private Person wife;
    private Person child;

    public ZagsChecker(String host, int port, String login, String password) {
        super(host, port, login, password);
    }

    public void setParameters(Person husband, Person wife, Person child) {
        this.husband = husband;
        this.wife = wife;
        this.child = child;
    }

    @Override
    protected CheckerAnswer sendAndGetData() throws SendGetDataException {
        if (Math.random() < LEVEL) {
            SendGetDataException ce = new SendGetDataException("Connection failed - host unknown");
            throw ce;
        }
        if(child == null) {
            return checkWedding();
        } else {
            return checkChild();
        }
    }

    private CheckerAnswer checkWedding() {
        System.out.println("ZagsChecker.checkWedding");
        return new BasicCheckerAnswer(true, "ZagsChecker.checkWedding");
    }

    private CheckerAnswer checkChild() {
        System.out.println("ZagsChecker.checkChild:" + child.getGivenName());
        return new BasicCheckerAnswer(true, "ZagsChecker.checkChild");
    }
}
