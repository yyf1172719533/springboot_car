package com.timain.web.sys.service;

import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.pojo.Role;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author yyf
 * @Version 1.0
 * @Date 2020/4/22 0022 19:13
 */
public interface RoleService {

    /**
     * 根据角色ID查询菜单权限
     * @param roleId
     * @return
     */
    Set<Menu> findMenusByRoleId(Integer roleId);

    /**
     * 根据条件查询所有角色信息
     * @return
     */
    List<Role> findAll(Integer available);
}
