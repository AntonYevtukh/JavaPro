package com.gmail.yevtukh.anton.homework.lection02.task03;

import com.gmail.yevtukh.anton.homework.lection02.task03.adapters.LocalDateAdapter;
import com.gmail.yevtukh.anton.homework.lection02.task03.adapters.LocalTimeAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
        return "id: " + id +
                "\nname: " + name +
                "\nrate: " + rate +
                "\ndate: " + date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                "\ntime: " + time.format(DateTimeFormatter.ofPattern("HH:mm")) +
                "\nask: " + ask +
                "\nbid: " + bid + "\n";
    }
}
