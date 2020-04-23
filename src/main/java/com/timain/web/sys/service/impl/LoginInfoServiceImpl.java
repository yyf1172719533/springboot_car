package com.timain.web.sys.service.impl;

import com.timain.web.sys.mapper.LoginInfoMapper;
import com.timain.web.sys.pojo.LoginInfo;
import com.timain.web.sys.service.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/23 15:36
 */
@Service
public class LoginInfoServiceImpl implements LoginInfoService {
    
    @Autowired
    private LoginInfoMapper loginInfoMapper;

    /**
     * 添加登录日志
     * @param loginInfo
     */
    @Override
    public void save(LoginInfo loginInfo) {
        loginInfoMapper.save(loginInfo);
    }
}
