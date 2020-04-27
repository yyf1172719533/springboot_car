package com.timain.web.sys.service;

import com.timain.web.sys.pojo.LoginInfo;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/23 15:35
 */
public interface LoginInfoService {

    /**
     * 添加登录日志
     * @param loginInfo
     */
    void save(LoginInfo loginInfo);
    
    
}
