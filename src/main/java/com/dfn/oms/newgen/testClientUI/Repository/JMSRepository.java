package com.dfn.oms.newgen.testClientUI.Repository;

import com.dfn.oms.newgen.testClientUI.bean.JMSComponent.JMS;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JMSRepository extends CrudRepository<JMS, Long> {

}

