package com.timain.web.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/22 16:30
 */
@Controller
@RequestMapping("/sys")
public class SysController {

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "sys/index/login";
    }
}
