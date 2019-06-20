package com.hellokoding.springboot.bean;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JMSRepository extends CrudRepository<JMS, Long> {

}

