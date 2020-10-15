package com.dinamo.microservices.readcsvfile;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query(value = "SELECT count(serial_number) FROM Person WHERE serial_number = :serialNumber")
    Integer countOfSerialNumber(@Param("serialNumber") Integer serialNumber);
}
