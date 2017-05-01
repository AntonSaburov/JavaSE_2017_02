package edu.javacourse.third.checkers;

import edu.javacourse.third.answer.CheckerAnswer;
import edu.javacourse.third.checkers.answer.BasicCheckerAnswer;
import edu.javacourse.third.domain.Person;
import edu.javacourse.third.exception.SendGetDataException;

/**
 * Created by antonsaburov on 02.03.17.
 */
public class StudentChecker extends BasicChecker
{
    private Person person;

    public StudentChecker(String host, int port, String login, String password) {
        super(host, port, login, password);
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    protected CheckerAnswer sendAndGetData() throws SendGetDataException {
        System.out.println("StudentChecker.sendAndGetData:" + person.getGivenName());
        if (Math.random() < LEVEL) {
            SendGetDataException ce = new SendGetDataException("Connection failed - host unknown");
            throw ce;
        }
        return new BasicCheckerAnswer(true, "StudentChecker:" + person.getGivenName());
    }
}
