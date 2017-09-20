package com.gmail.yevtukh.anton.homework.lection02.task01;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Anton on 20.09.2017.
 */
public class TrainFilter extends XmlAdapter<Train, Train> {

    //Фильтрует поезда по дате и времени при демаршалинге
    @Override
    public Train unmarshal(Train train) throws Exception {
        if (!train.getDate().equals(LocalDate.now()) ||
                train.getDeparture().isBefore(LocalTime.of(15, 0)) ||
                train.getDeparture().isAfter(LocalTime.of(19, 0)))
            throw new Exception("Adapter");
        return train;
    }

    @Override
    public Train marshal(Train train) throws Exception {
        return train;
    }
}
