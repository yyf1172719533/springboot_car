package com.timain.web.sys.service.impl;

import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.pojo.Role;
import com.timain.web.sys.service.RoleService;
import com.timain.web.sys.vo.RoleVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    void findAllBySome() {
        RoleVO roleVO = new RoleVO();
        roleVO.setRoleName("业务");
        DataGridView dataGridView = this.roleService.queryAllBySome(roleVO);
        System.out.println(dataGridView);
    }
    
    @Test
    @Transactional
    void testSaveRoleMenu() {
        this.roleService.saveRoleMenu(1, null);
    }
    
}