package com.timain.web.sys.service.impl;

import com.timain.web.sys.mapper.UserMapper;
import com.timain.web.sys.pojo.Role;
import com.timain.web.sys.pojo.User;
import com.timain.web.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/22 16:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据登录名查询用户对象
     *
     * @param loginName
     * @return
     */
    @Override
    public User findByName(String loginName) {
        return userMapper.findByLoginName(loginName);
    }

    /**
     * 根据用户ID查询用户角色
     *
     * @param userId
     * @return
     */
    @Override
    public Set<Role> findRolesByUserId(Integer userId) {
        Optional<User> optional = userMapper.findById(userId);
        return optional.get().getRoles();
    }
}
