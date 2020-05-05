package com.timain.web.sys.controller;

import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.service.RoleService;
import com.timain.web.sys.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yyf
 * @Version 1.0
 * @Date 2020/5/3 0003 21:47
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 分页条件查询角色列表
     * @param roleVO
     * @return
     */
    @RequestMapping("findAllRoles")
    public DataGridView findAllRoles(RoleVO roleVO) {
        return this.roleService.queryAllBySome(roleVO);
    }
}
