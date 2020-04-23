package com.timain.web.sys.controller;

import com.timain.web.sys.common.ResultObj;
import com.timain.web.sys.dto.UserDTO;
import com.timain.web.sys.pojo.LoginInfo;
import com.timain.web.sys.service.LoginInfoService;
import com.timain.web.sys.utils.LoginUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/23 14:15
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private LoginInfoService loginInfoService;

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    @RequestMapping("login")
    public ResultObj login(String loginName, String password) {
        //获得主体对象
        Subject subject = SecurityUtils.getSubject();
        //根据用户名、密码、是否记住获得token
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        System.out.println(token);
        try {
            //登录
            subject.login(token);
            UserDTO userDTO = (UserDTO) subject.getPrincipal();
            LoginUtils.getSession().setAttribute("user", userDTO.getUser());

            //记录用户登录日志信息
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setLoginIp(LoginUtils.getRequest().getRemoteAddr());
            loginInfo.setLoginName(userDTO.getUser().getRealName() + "-" + userDTO.getUser().getLoginName());
            loginInfo.setLoginTime(new Date());
            loginInfoService.save(loginInfo);
            return ResultObj.LOGIN_SUCCESS;
        } catch (Exception e) {
            return ResultObj.LOGIN_ERROR_NAME_OR_PWD;
        }
    }

    /**
     * 用户退出
     * @return
     */
    @RequestMapping("logout")
    public ResultObj logout() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            return ResultObj.LOGOUT_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.LOGOUT_ERROR;
        }
    }
}
