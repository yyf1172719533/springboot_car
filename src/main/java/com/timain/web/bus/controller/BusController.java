package com.timain.web.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/5/19 10:45
 */
@Controller
@RequestMapping("bus")
public class BusController {

    /**
     * 跳转到客户管理页面
     * @return
     */
    @RequestMapping("toCustomerManager")
    public String toCustomerManager() {
        return "bus/customer/customer";
    }
}
