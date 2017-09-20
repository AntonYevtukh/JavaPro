package com.gmail.yevtukh.anton.homework.lection02.task03;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created by Anton on 20.09.2017.
 */
@XmlRootElement(name = "query")
public class Query {

    @XmlAttribute(name = "yahoo:xmlns")
    private String xmlns;
    @XmlAttribute(name = "yahoo:count")
    private int count;
    @XmlAttribute(name = "yahoo:created")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime dateTime;
    @XmlAttribute(name = "yahoo:lang")
    private String language;
    @XmlElement(name = "results")
    private Results results;

    @Override
    public String toString() {
        return "Query{" +
                "xmlns='" + xmlns + '\'' +
                ", count=" + count +
                ", dateTime=" + dateTime +
                ", language='" + language + '\'' +
                ", results=" + results +
                '}';
    }
}
