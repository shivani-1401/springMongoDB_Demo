package com.stackroute.springmongodb.domain;

public class Hobby {

    private String hobbyName;
    private String since;

    public Hobby() {
    }

    public Hobby(String hobbyName, String since) {
        this.hobbyName = hobbyName;
        this.since = since;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobbyName='" + hobbyName + '\'' +
                ", since='" + since + '\'' +
                '}';
    }
}
