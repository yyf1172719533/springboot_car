package com.timain.web.bus.service;

import com.timain.web.bus.pojo.Customer;
import com.timain.web.bus.vo.CustomerVO;
import com.timain.web.sys.common.DataGridView;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/5/19 10:44
 */
public interface CustomerService {

    /**
     * 条件分页查询客户信息
     * @param customerVO
     * @return
     */
    DataGridView findAllCustomers(CustomerVO customerVO);

    /**
     * 添加或修改客户信息
     * @param customer
     */
    void addOrUpdateCustomer(Customer customer);

    /**
     * 根据ID删除客户
     * @param id
     */
    void deleteCustomer(Integer id);
    
}
