package com.gmail.yevtukh.anton.homework.lection02.task01;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by Anton on 19.09.2017.
 */
@XmlRootElement(name = "trains")
@XmlAccessorType(XmlAccessType.FIELD)
public class Trains {

    @XmlElement(name = "train")
    //Раскомментировать, чтобы при чтении XML, считывались только сегодняшне поезда с 15:00 до 19:00
    //@XmlJavaTypeAdapter(TrainFilter.class)
    private List<Train> trainsList;

    public Trains() {
        trainsList = new ArrayList<>();
    }

    public Trains(Train... trains) {
        trainsList = new ArrayList<>(Arrays.asList(trains));
    }

    public Trains(Trains trains) {
        this.trainsList = trains.trainsList;
    }

    public Trains addTrains(Train... trains) {
        trainsList.addAll(Arrays.asList(trains));
        return this;
    }

    public Trains removeTrains(Train... trains) {
        trainsList.removeAll(Arrays.asList(trains));
        return this;
    }

    public List<Train> getTrainsList() {
        return trainsList;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n", "Trains:\n\n", "");
        trainsList.forEach(train -> stringJoiner.add(train.toString()));
        return stringJoiner.toString();
    }

    public String toFilteredString(LocalDate onDate, LocalTime fromTime, LocalTime toTime) {
        StringJoiner stringJoiner = new StringJoiner("\n", "Trains:\n\n", "");
        trainsList.forEach(train -> {
            if (train.getDate().equals(onDate) &&
                    (train.getDeparture().isAfter(fromTime)) && train.getDeparture().isBefore(toTime))
            stringJoiner.add(train.toString());
        });
        return stringJoiner.toString();
    }
}
