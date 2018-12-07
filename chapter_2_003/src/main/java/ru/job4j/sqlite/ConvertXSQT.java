package ru.job4j.sqlite;

import org.testng.reporters.Files;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;

public class ConvertXSQT {
    public void convert(File source, File dest, File scheme) {
        String src = "";
        String schm = "";

        try {
            src = Files.readFile(source);
            schm = Files.readFile(scheme);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(
                    new StreamSource(
                            new ByteArrayInputStream(schm.getBytes()))
            );
            String result = "";
            transformer.transform(new StreamSource(
                            new ByteArrayInputStream(src.getBytes())),
                    new StreamResult(dest)
            );
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
