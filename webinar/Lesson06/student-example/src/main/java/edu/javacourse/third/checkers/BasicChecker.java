package edu.javacourse.third.checkers;

import edu.javacourse.third.exception.CheckException;
import edu.javacourse.third.exception.ConnectException;
import edu.javacourse.third.exception.SendGetDataException;

/**
 * Created by antonsaburov on 02.03.17.
 */
public abstract class BasicChecker
{
    protected final static double LEVEL = -1.000;

    protected String host;
    protected int port;
    protected String login;
    protected String password;

    public BasicChecker(String host, int port, String login, String password) {
        this.host = host;
        this.port = port;
        this.login = login;
        this.password = password;
    }

    public boolean check() throws CheckException {
        try {
            connect();
            try {
                boolean result = sendAndGetData();
                return result;
            } catch (SendGetDataException ex) {
                throw new CheckException(ex.getMessage(), ex);
            } finally {
                disconnect();
            }
        } catch (ConnectException ex) {
            throw new CheckException(ex.getMessage(), ex);
        }
    }

    private void connect() throws ConnectException {
        System.out.println("Basic.connect");
        // Напишем, что мы соединимся - обязуемся
        if (Math.random() < LEVEL) {
            ConnectException ce = new ConnectException("Connection failed - host unknown");
            throw ce;
        }
    }

    private void disconnect() {
        System.out.println("Basic.disconnect");
        // Напишем, что мы соединимся - обязуемся
    }

    protected abstract boolean sendAndGetData() throws SendGetDataException;
}
