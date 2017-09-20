package com.gmail.yevtukh.anton.homework.lection02.task01;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Anton on 20.09.2017.
 */
public class LocalTimeAdapter extends XmlAdapter<String, LocalTime>{

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public String marshal(LocalTime time) {
        return FORMATTER.format(time);
    }

    public LocalTime unmarshal(String timeString) {
        return LocalTime.parse(timeString, FORMATTER);
    }
}
