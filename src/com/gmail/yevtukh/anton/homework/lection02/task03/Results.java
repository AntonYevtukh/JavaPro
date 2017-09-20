package com.gmail.yevtukh.anton.homework.lection02.task03;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by Anton on 20.09.2017.
 */
@XmlRootElement(name = "results")
public class Results {

    @XmlElement(name = "rate")
    private Rate[] rates;

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        Arrays.asList(rates).forEach(rate -> stringJoiner.add(rate.toString()));
        return stringJoiner.toString();
    }
}
