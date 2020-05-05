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
     * 跳转到用户管理页面
     * @return
     */
    @RequestMapping("toUserManager")
    public String toUserManager() {
        return "sys/user/userList";
    }

    /**
     * 跳转到公告管理页面
     * @return
     */
    @RequestMapping("toNoticesManager")
    public String toNoticesManager() {
        return "sys/notices/NoticesInfo";
    }

    /**
     * 跳转到日志管理页面
     * @return
     */
    @RequestMapping("toLogInfoManager")
    public String toLogInfoManager() {
        return "sys/logInfo/LogInfo";
    }

    /**
     * 跳转到角色管理页面
     * @return
     */
    @RequestMapping("toRoleManager")
    public String toRoleManager() {
        return "sys/role/roleList";
    }
}
