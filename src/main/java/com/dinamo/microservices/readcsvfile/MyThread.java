package com.dinamo.microservices.readcsvfile;

class MyThread extends Thread {

    private Person person;

    private ReadCSVFileService readCSVFileService;

    public MyThread(ReadCSVFileService readCSVFileService, Person person) {
        this.readCSVFileService = readCSVFileService;
        this.person = person;
    }

    @Override
    public void run() {
        int countRecords = readCSVFileService.countDuplicatesOfSerialNumber(person.getSerialNumber());
        System.out.println("ID"+"("+ person.getSerialNumber() +") with "+ " No. of Duplicates/Records: " + countRecords);
        if (countRecords == 0) {
            readCSVFileService.saveRecordToOtherTable(person);
        }
    }
}
