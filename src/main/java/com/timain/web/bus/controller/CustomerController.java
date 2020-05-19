package com.timain.web.bus.controller;

import com.timain.web.bus.pojo.Customer;
import com.timain.web.bus.service.CustomerService;
import com.timain.web.bus.vo.CustomerVO;
import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.common.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/5/19 10:44
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @RequestMapping("loadAllCustomers")
    public DataGridView loadAllCustomers(CustomerVO customerVO) {
        return this.customerService.findAllCustomers(customerVO);
    }
    
    @RequestMapping("addCustomer")
    public ResultObj addCustomer(Customer customer) {
        try {
            customer.setCreateTime(new Date());
            this.customerService.addOrUpdateCustomer(customer);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    
    @RequestMapping("updateCustomer")
    public ResultObj updateCustomer(Customer customer) {
        try {
            customer.setCreateTime(new Date());
            this.customerService.addOrUpdateCustomer(customer);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
    
    @RequestMapping("deleteCustomer")
    public ResultObj deleteCustomer(Integer id) {
        try {
            this.customerService.deleteCustomer(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping("deleteBachByIds")
    public ResultObj deleteBachByIds(CustomerVO customerVO) {
        try {
            Integer[] ids = customerVO.getIds();
            for (Integer id : ids) {
                this.customerService.deleteCustomer(id);
            }
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
