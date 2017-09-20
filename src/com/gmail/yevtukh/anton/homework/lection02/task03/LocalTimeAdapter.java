package com.gmail.yevtukh.anton.homework.lection02.task03;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Anton on 20.09.2017.
 */
public class LocalTimeAdapter extends XmlAdapter<String, LocalTime>{

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("h:mma");

    public String marshal(LocalTime time) {
        return FORMATTER.format(time);
    }

    public LocalTime unmarshal(String timeString) {
        return LocalTime.parse(timeString.toUpperCase(), FORMATTER);
    }
}
