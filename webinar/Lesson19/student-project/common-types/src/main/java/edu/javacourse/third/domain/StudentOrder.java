package edu.javacourse.third.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by antonsaburov on 27.02.17.
 */
public class StudentOrder implements Serializable
{
    private Long studentOrderId;
    private Date studentOrderDate;
    private PersonAdult husband;
    private PersonAdult wife;
    private List<PersonChild> children;

    public StudentOrder() {
    }

    public StudentOrder(Long studentOrderId, Date studentOrderDate, PersonAdult husband, PersonAdult wife, List<PersonChild> children) {
        this.studentOrderId = studentOrderId;
        this.studentOrderDate = studentOrderDate;
        this.husband = husband;
        this.wife = wife;
        this.children = children;
    }

    public Long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(Long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Date getStudentOrderDate() {
        return studentOrderDate;
    }

    public void setStudentOrderDate(Date studentOrderDate) {
        this.studentOrderDate = studentOrderDate;
    }

    public PersonAdult getHusband() {
        return husband;
    }

    public PersonAdult getWife() {
        return wife;
    }

    public List<PersonChild> getChildren() {
        return children;
    }

    public void setHusband(PersonAdult husband) {
        this.husband = husband;
    }

    public void setWife(PersonAdult wife) {
        this.wife = wife;
    }

    public void setChildren(List<PersonChild> children) {
        this.children = children;
    }
}
