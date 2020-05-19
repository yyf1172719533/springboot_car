package com.timain.web.bus.service.impl;

import com.timain.web.bus.service.CustomerService;
import com.timain.web.bus.vo.CustomerVO;
import com.timain.web.sys.common.DataGridView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/5/19 13:09
 */
@SpringBootTest
class CustomerServiceImplTest {
    
    @Autowired
    private CustomerService customerService;

    @Test
    void findAllCustomers() {
        CustomerVO customerVO = new CustomerVO();
        DataGridView gridView = this.customerService.findAllCustomers(customerVO);
        System.out.println(gridView);
    }
}