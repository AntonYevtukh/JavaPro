package com.gmail.yevtukh.anton.homework.lection02.task03;

import com.gmail.yevtukh.anton.homework.lection02.task03.adapters.ZonedDateTimeAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Anton on 20.09.2017.
 */
@XmlRootElement(name = "query")
public class Query {

    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng", name = "count")
    private int count;
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng", name = "created")
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    private ZonedDateTime created;
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng", name = "lang")
    private String language;
    @XmlElement(name = "results")
    private Results results;

    @Override
    public String toString() {
        return "Query:" +
                "\ncount: " + count +
                "\ncreated: " + created.format(DateTimeFormatter.ofPattern("dd.MM.yyyy'T'HH:mm:ss")) +
                "\nlanguage: " + language +
                "\nresults:\n\n" + results;
    }
}
