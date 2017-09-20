package com.gmail.yevtukh.anton.homework.lection02.task02;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Anton on 20.09.2017.
 */
public class Person {

    private String name;
    private String surname;
    private String[] sites;
    private String[] phones;
    private Address address;

    public Person() {

    }

    public Person(String name, String surname, String[] sites, String[] phones, Address address) {
        this.name = name;
        this.surname = surname;
        this.sites = sites;
        this.phones = phones;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String[] getSites() {
        return sites;
    }

    public void setSites(String[] sites) {
        this.sites = sites;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {

        return "name: " + name +
                "\nsurname: " + surname +
                "\nsites: " + Arrays.toString(sites).replace("[", "").replace("]", "") +
                "\nphones: " + Arrays.toString(phones).replace("[", "").replace("]", "") +
                "\naddress:\n" + address;
    }
}
