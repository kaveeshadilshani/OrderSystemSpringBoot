package com.dfn.oms.newgen.testClientUI.bean;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends CrudRepository<OrderParams, Long> {

}

