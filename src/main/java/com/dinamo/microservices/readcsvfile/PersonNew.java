package com.dinamo.microservices.readcsvfile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int serialNumber;
    private String firstName;
    private String lastName;

    public PersonNew() {
    }

    public PersonNew(int serialNumber, String firstName, String lastName) {
        super();
        this.serialNumber = serialNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonNew(int id, int serialNumber, String firstName, String lastName) {
        super();
        this.id = id;
        this.serialNumber = serialNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
