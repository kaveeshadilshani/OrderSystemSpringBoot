package com.dfn.oms.newgen.testClientUI.Repository;

import com.dfn.oms.newgen.testClientUI.bean.CreateOrderComponent.OrderParams;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends CrudRepository<OrderParams, Long> {

}

