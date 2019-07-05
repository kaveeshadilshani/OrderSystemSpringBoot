package com.dfn.oms.newgen.testClientUI.Repository;

import com.dfn.oms.newgen.testClientUI.bean.CreateOrderComponent.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
