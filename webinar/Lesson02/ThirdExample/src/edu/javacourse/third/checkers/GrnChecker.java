package edu.javacourse.third.checkers;

import edu.javacourse.third.domain.Person;

/**
 * Created by antonsaburov on 27.02.17.
 */
public class GrnChecker
{
    private String ip;
    private int port;
    private String login;
    private String password;

    public boolean checkGRN(Person p) {
        System.out.println("Check:" + p.getGivenName());
        connect();
//        p.surName = "Test";
        // Она тут много чего интересного делает
        return true;
    }

    private void connect() {
        // Соединяемся с удаленной программой
        System.out.println(this.ip + ", " + port);
        System.out.println(login + "/" + password);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
