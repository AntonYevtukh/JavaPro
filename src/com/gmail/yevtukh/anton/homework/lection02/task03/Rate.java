package com.gmail.yevtukh.anton.homework.lection02.task03;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Anton on 20.09.2017.
 */
@XmlRootElement(name = "rate")
public class Rate {

    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Rate")
    private double rate;
    @XmlElement(name = "Date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate date;
    @XmlElement(name = "Time")
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    private LocalTime time;
    @XmlElement(name = "Ask")
    private double ask;
    @XmlElement(name = "Bid")
    private double bid;

    @Override
    public String toString() {
        return "Rate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", date=" + date +
                ", time=" + time +
                ", ask=" + ask +
                ", bid=" + bid +
                '}';
    }
}
