package com.gmail.yevtukh.anton.homework.lection02.task01;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Anton on 19.09.2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "train")
//@XmlJavaTypeAdapter(TrainAdapter.class)
public class Train {

    @XmlAttribute
    private String id;
    @XmlElement
    private String origin;
    @XmlElement
    private String destination;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate date;
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    private LocalTime departure;

    public Train() {

    }

    public Train(String id, String origin, String destination, LocalDate date, LocalTime departure) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.departure = departure;
    }

    public String getUniqueId() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return id + " " + dateFormatter.format(date);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "Train №" + id +
                ":\nOrigin: " + origin +
                "\nDestination: " + destination +
                "\nDate: " + date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                "\nDeparture: " + departure.format(DateTimeFormatter.ofPattern("HH:mm")) + ";\n";
    }
}
