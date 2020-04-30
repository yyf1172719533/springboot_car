package com.timain.web.sys.service.impl;

import com.timain.web.sys.mapper.RoleMapper;
import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.pojo.Role;
import com.timain.web.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author yyf
 * @Version 1.0
 * @Date 2020/4/22 0022 19:14
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据角色ID查询菜单权限
     *
     * @param roleId
     * @return
     */
    @Override
    public Set<Menu> findMenusByRoleId(Integer roleId) {
        Optional<Role> optional = this.roleMapper.findById(roleId);
        return optional.get().getMenus();
    }

    /**
     * 根据条件查询所有角色信息
     *
     * @param available
     * @return
     */
    @Override
    public List<Role> findAll(Integer available) {
        return this.roleMapper.findAllByAvailable(available);
    }
}
