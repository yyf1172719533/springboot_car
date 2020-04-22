package com.timain.web.sys.service;

import com.timain.web.sys.pojo.Role;
import com.timain.web.sys.pojo.User;

import java.util.Set;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/22 16:17
 */
public interface UserService {

    /**
     * 根据登录名查询用户对象
     * @param loginName
     * @return
     */
    User findByName(String loginName);

    /**
     * 根据用户ID查询用户角色
     * @param userId
     * @return
     */
    Set<Role> findRolesByUserId(Integer userId);
}
