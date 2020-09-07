package com.stackroute.springmongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Employee {

    @Id
    private String empId;
    private String empName;
    private String empEmail;
    private String empContact;
    private Address address;
    private List<Hobby> hobbyList;

    public Employee() {
    }

    public Employee(String empId, String empName, String empEmail, String empContact, Address address, List<Hobby> hobbyList) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empContact = empContact;
        this.address = address;
        this.hobbyList = hobbyList;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpContact() {
        return empContact;
    }

    public void setEmpContact(String empContact) {
        this.empContact = empContact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Hobby> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empContact='" + empContact + '\'' +
                ", address=" + address +
                ", hobbyList=" + hobbyList +
                '}';
    }
}
