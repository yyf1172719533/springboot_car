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

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("toIndex")
    public String toIndex() {
        return "sys/index/index";
    }

    /**
     * 跳转到后台首页
     * @return
     */
    @RequestMapping("toMain")
    public String toMain() {
        return "sys/index/main";
    }

    /**
     * 跳转到用户中心
     * @return
     */
    @RequestMapping("toUserList")
    public String toUserList() {
        return "sys/user/userList";
    }
}
