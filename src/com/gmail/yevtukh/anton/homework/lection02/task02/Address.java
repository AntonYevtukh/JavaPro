package com.gmail.yevtukh.anton.homework.lection02.task02;

/**
 * Created by Anton on 20.09.2017.
 */
public class Address {

    private String country;
    private String city;
    private String street;

    public Address() {

    }

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return
                "\tcountry: " + country +
                "\n\tcity: " + city +
                "\n\tstreet: " + street;
    }
}
