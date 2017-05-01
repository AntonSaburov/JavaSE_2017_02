package edu.javacourse.third.checkers;

import edu.javacourse.third.domain.Person;
import edu.javacourse.third.exception.ConnectException;
import edu.javacourse.third.exception.SendGetDataException;

/**
 * Created by antonsaburov on 27.02.17.
 */
public class GrnChecker extends BasicChecker
{
    private Person person;

    public GrnChecker(String host, int port, String login, String password) {
        super(host, port, login, password);
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    protected boolean sendAndGetData() throws SendGetDataException {
        System.out.println("GrnChecker.sendAndGetData:" + person.getGivenName());
        if (Math.random() < LEVEL) {
            SendGetDataException ce = new SendGetDataException("Connection failed - host unknown");
            throw ce;
        }
        return true;
    }
}
