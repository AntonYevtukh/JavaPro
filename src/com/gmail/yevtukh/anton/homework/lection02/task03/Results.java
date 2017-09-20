package com.gmail.yevtukh.anton.homework.lection02.task03;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 * Created by Anton on 20.09.2017.
 */
@XmlRootElement(name = "results")
public class Results {

    @XmlElement(name = "rate")
    private Rate[] rates;

    @Override
    public String toString() {
        return "Results{" +
                "rates=" + Arrays.toString(rates) +
                '}';
    }
}
