package com.timain.web.sys.controller;

import com.timain.web.sys.common.Constants;
import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.common.ResultObj;
import com.timain.web.sys.common.TreeNode;
import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.pojo.Role;
import com.timain.web.sys.service.MenuService;
import com.timain.web.sys.service.RoleService;
import com.timain.web.sys.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @Autowired
    private MenuService menuService;

    /**
     * 分页条件查询角色列表
     * @param roleVO
     * @return
     */
    @RequestMapping("findAllRoles")
    public DataGridView findAllRoles(RoleVO roleVO) {
        return this.roleService.queryAllBySome(roleVO);
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping("addRole")
    public ResultObj addRole(Role role) {
        try {
            this.roleService.saveOrUpdateRole(role);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改角色信息
     * @param role
     * @return
     */
    @RequestMapping("updateRole")
    public ResultObj updateRole(Role role) {
        try {
            this.roleService.saveOrUpdateRole(role);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除角色信息
     * @param roleId
     * @return
     */
    @RequestMapping("deleteRole")
    public ResultObj deleteRole(Integer roleId) {
        try {
            this.roleService.deleteRole(roleId);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 根据角色ID加载菜单信息
     * @param roleId
     * @return
     */
    @RequestMapping("initMenuByRoleId")
    public DataGridView initMenuByRoleId(Integer roleId) {
        //查询所有可用的菜单
        List<Menu> menuList = menuService.findAllMenus(Constants.AVAILABLE_TRUE);
        //根据角色ID查询菜单权限
        Set<Menu> menuSet = roleService.findMenusByRoleId(roleId);
        List<TreeNode> nodes = new ArrayList<>();
        for (Menu m1 : menuList) {
            String checkArr = "0";
            for (Menu m2 : menuSet) {
                if (m2.getId()==m1.getId()) {
                    checkArr = "1";
                    break;
                }
            }
            Boolean spread = m1.getSpread()==1?true:false;
            nodes.add(new TreeNode(m1.getId(), m1.getPId(), m1.getTitle(), spread, checkArr));
        }
        return new DataGridView(nodes);
    }
    
    @RequestMapping("saveRoleMenu")
    public ResultObj saveRoleMenu(Integer roleId, Integer[] menuIds) {
        return null;
    }
}
