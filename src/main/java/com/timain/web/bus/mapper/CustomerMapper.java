package com.timain.web.bus.mapper;

import com.timain.web.bus.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/5/19 10:39
 */
public interface CustomerMapper extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor {
}
