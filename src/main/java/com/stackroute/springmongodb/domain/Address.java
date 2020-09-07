package com.stackroute.springmongodb.domain;

public class Address {
    private String houseNo;
    private String street;
    private String city;
    private String state;

    public Address() {
    }

    public Address(String houseNo, String street, String city, String state) {
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo='" + houseNo + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
