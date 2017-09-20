package com.gmail.yevtukh.anton.homework.lection02.task01;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Anton on 19.09.2017.
 */
public class Runner {

    private static final String SAVE_PATH = "D:\\Files\\trains.xml";
    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalTime SHOW_FROM = LocalTime.of(15, 0);
    private static final LocalTime SHOW_TO = LocalTime.of(19, 0);

    public static void main(String[] args) {
        Train train1 = new Train("743L", "Kyiv", "Lviv",
                LocalDate.now(), LocalTime.of(17, 35));
        Train train2 = new Train("726K", "Kyiv", "Kharkiv",
                LocalDate.of(2017, 9, 13), LocalTime.of(18, 1));
        Train train3 = new Train("734L", "Kyiv", "Dnipro",
                LocalDate.now(), LocalTime.of(17, 35));

        Trains trains = new Trains(train1, train2);

        XmlUtils.marshal(trains, SAVE_PATH);
        addTrainsToFile(SAVE_PATH, train3);
        trains = XmlUtils.unmarshal(Trains.class, SAVE_PATH);
        System.out.println(trains.toFilteredString(TODAY, SHOW_FROM, SHOW_TO));
    }

    private static void addTrainsToFile(String savePath, Train... trainsArray) {
        Trains trains = XmlUtils.unmarshal(Trains.class, savePath);
        trains.addTrains(trainsArray);
        XmlUtils.marshal(trains, savePath);
    }
}
