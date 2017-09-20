package com.gmail.yevtukh.anton.homework.lection02.task03;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Anton on 20.09.2017.
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime>{

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_INSTANT;

    public String marshal(LocalDateTime dateTime) {
        return FORMATTER.format(dateTime);
    }

    public LocalDateTime unmarshal(String dateString) {
        return LocalDateTime.parse(dateString, FORMATTER);
    }
}
