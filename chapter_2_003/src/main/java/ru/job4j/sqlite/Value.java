package ru.job4j.sqlite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "values")
@XmlAccessorType(XmlAccessType.FIELD)
public class Value {
    private int value;

    public Value() {
    }

    public Value(int field) {
        this.value = field;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
