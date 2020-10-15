package com.dinamo.microservices.readcsvfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadCSVFileController {

    @Autowired
    private ReadCSVFileService readCSVFileService;

//    http://localhost:5000/read-csv
    @GetMapping("/read-csv")
    public String readCSVFile() {
        readCSVFileService.readCSVFile("CSVDemo1.csv");
        System.out.println("No. of records in CSV file::" +readCSVFileService.getPersonList().size());
        readCSVFileService.parsePersonMap();

        return "SUCCESS";
    }
}
