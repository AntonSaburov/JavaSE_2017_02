package edu.javacourse.third.domain;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by antonsaburov on 27.02.17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentOrder implements Serializable
{
    @XmlAttribute(name = "so-id", required = true)
    private Long studentOrderId;
    @XmlElement(name = "husband", required = true)
    private PersonAdult husband;
    @XmlElement(name = "wife", required = true)
    private PersonAdult wife;
    @XmlElementWrapper(name="children")
    @XmlElement(name = "child", required = true)
    private List<PersonChild> children;

    public StudentOrder() {
    }

    public StudentOrder(PersonAdult husband, PersonAdult wife, List<PersonChild> children) {
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

    public PersonAdult getHusband() {
        return husband;
    }

    public PersonAdult getWife() {
        return wife;
    }

    public void setHusband(PersonAdult husband) {
        this.husband = husband;
    }

    public void setWife(PersonAdult wife) {
        this.wife = wife;
    }

    public List<PersonChild> getChildren() {
        return children;
    }

    public void setChildren(List<PersonChild> children) {
        this.children = children;
    }
}
