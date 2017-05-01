package edu.javacourse.third.domain;

/**
 * Created by antonsaburov on 06.03.17.
 */
public class PersonChild extends Person
{
    private String birthDocument;

    public String getBirthDocument() {
        return birthDocument;
    }

    public void setBirthDocument(String birthDocument) {
        this.birthDocument = birthDocument;
    }
}
