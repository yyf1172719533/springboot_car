package com.timain.web.sys.service.impl;

import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.pojo.Role;
import com.timain.web.sys.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 13:35
 */
@SpringBootTest
class UserServiceImplTest {
    
    @Autowired
    private UserService userService;

    @Test
    void findByName() {
        Long count = userService.findCount();
        System.out.println(count);
    }
    
    @Test
    void findRolesByUserId() {
        Set<Role> roleSet = userService.findRolesByUserId(1);
        for (Role role : roleSet) {
            System.out.println(role);
        }
    }
    
    @Test
    void findMenusByUserId() {
        Set<Menu> menuSet = userService.findMenusByUserId(1);
        menuSet.forEach(System.out::println);
    }
}