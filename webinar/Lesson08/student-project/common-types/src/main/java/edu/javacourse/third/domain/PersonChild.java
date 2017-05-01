package edu.javacourse.third.domain;

import java.io.Serializable;

/**
 * Created by antonsaburov on 06.03.17.
 */
public class PersonChild extends Person implements Serializable
{
    private String birthDocument;

    public String getBirthDocument() {
        return birthDocument;
    }

    public void setBirthDocument(String birthDocument) {
        this.birthDocument = birthDocument;
    }
}
