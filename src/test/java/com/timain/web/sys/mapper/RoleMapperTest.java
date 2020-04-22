package com.timain.web.sys.mapper;

import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.pojo.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author yyf
 * @Version 1.0
 * @Date 2020/4/22 0022 22:25
 */
@SpringBootTest
class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void testFindMenusByRoleId() {
        Optional<Role> optional = roleMapper.findById(1);
        Role role = optional.get();
        Set<Menu> menus = role.getMenus();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }

}