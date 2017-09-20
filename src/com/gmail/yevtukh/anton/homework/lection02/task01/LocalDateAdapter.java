package com.gmail.yevtukh.anton.homework.lection02.task01;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Anton on 20.09.2017.
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate>{

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public String marshal(LocalDate date) {
        return FORMATTER.format(date);
    }

    public LocalDate unmarshal(String dateString) {
        return LocalDate.parse(dateString, FORMATTER);
    }
}
