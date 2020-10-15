package com.dinamo.microservices.readcsvfile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonNewRepository extends CrudRepository<PersonNew, Integer>  {
}
