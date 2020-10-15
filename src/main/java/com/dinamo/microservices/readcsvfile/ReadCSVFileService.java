package com.dinamo.microservices.readcsvfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReadCSVFileService {

    private List<Person> personList = new ArrayList<>();

    private Map<String, Person> personMap = new HashMap<>();

    @Autowired
    private ReadCSVFileController readCSVFileController;

    @Autowired
    private PersonNewRepository personNewRepository;

    @Autowired
    private PersonRepository personRepository;

    public void readCSVFile(String fileName) {
        personList.clear();
        personMap.clear();
        String line = "";
        String splitBy = ",";

        System.out.println("File location: " + new File("CSVDemo1.csv").getAbsoluteFile());
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] person = line.split(splitBy);    // use comma as separator
                System.out.println("Person [Serial Number=" + person[0] + ", First Name=" + person[1] + ", Last Name=" + person[2] + ", Designation=" + person[3]+"]");
//                personList.add(new Person(Integer.parseInt(person[0]), person[1], person[2]));
                personMap.put(person[0], new Person(Integer.parseInt(person[0]), person[1], person[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parsePersonList() {
        for (Person person : personList) {
            int countRecords = countDuplicatesOfSerialNumber(person.getSerialNumber());
            System.out.println("ID"+"("+ person.getSerialNumber() +")"+ " No. of Records: " + countRecords);
            if (countRecords == 0) {
                saveRecordToOtherTable(person);
            }
        }
    }

    public void parsePersonMap() {
        for (Map.Entry<String, Person> set : personMap.entrySet()) {
            new MyThread(this, set.getValue()).start();
        }
    }

    public void saveRecordToOtherTable(Person value) {
        System.out.println("Insert records to Person New table");
        personNewRepository.save(new PersonNew(value.getSerialNumber(), value.getFirstName(), value.getLastName()));
    }

    public Integer countDuplicatesOfSerialNumber(int serialNumber) {
        Integer count = personRepository.countOfSerialNumber(serialNumber);
        return count;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
