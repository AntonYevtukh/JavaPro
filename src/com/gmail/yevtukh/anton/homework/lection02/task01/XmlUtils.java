package com.gmail.yevtukh.anton.homework.lection02.task01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Anton on 20.09.2017.
 */
public class XmlUtils {

    public static void marshal(Object obj, String savePath) {

        try {
            File file = new File(savePath);
            file.getParentFile().mkdirs();
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(obj, file);
            //marshaller.marshal(obj, System.out);

        } catch (JAXBException e) {
            throw new RuntimeException("Can't marshal object:\n" + obj);
        }
    }

    public static <T> T unmarshal(Class<T> classToken, String savePath) {
        try {
            File file = new File(savePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(classToken);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't unmarshal from file:\n" + savePath);
        }
    }
}
