package com.timain.web.sys.service.impl;

import com.timain.web.sys.pojo.Role;
import com.timain.web.sys.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/30 9:44
 */
@SpringBootTest
class RoleServiceImplTest {
    
    @Autowired
    private RoleService roleService;

    @Test
    void findMenusByRoleId() {
        List<Role> list = roleService.findAll(1);
        for (Role role : list) {
            System.out.println(role);
        }
    }
}