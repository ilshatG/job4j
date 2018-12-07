package ru.job4j.sqlite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)


public class Values {
    @XmlElement(name = "values")
    private List<Value> elements = new ArrayList();

    public Values() {
    }


    public void setElements(List<Value> elements) {
        this.elements = elements;
    }

    public List<Value> getElements() {
        return elements;
    }

    Values(List<Value> items) {
        this.elements = items;
    }
}
