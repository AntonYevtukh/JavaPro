package com.gmail.yevtukh.anton.homework.lection02.task03.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Anton on 20.09.2017.
 */
public class ZonedDateTimeAdapter extends XmlAdapter<String, ZonedDateTime>{

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");

    public String marshal(ZonedDateTime dateTime) {
        return FORMATTER.format(dateTime);
    }

    public ZonedDateTime unmarshal(String dateString) {
        return ZonedDateTime.parse(dateString, FORMATTER);
    }
}
