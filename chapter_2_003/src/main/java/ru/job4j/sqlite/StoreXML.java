package ru.job4j.sqlite;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class StoreXML {
    private File target;
    StoreXML(File target) {
        this.target = target;
    }

    public void save(Values values) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Values.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(values, target);
            //jaxbMarshaller.marshal(values, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
