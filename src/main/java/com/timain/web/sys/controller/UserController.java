package com.timain.web.sys.controller;

import com.timain.web.sys.common.Constants;
import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.common.ResultObj;
import com.timain.web.sys.pojo.Role;
import com.timain.web.sys.pojo.User;
import com.timain.web.sys.service.RoleService;
import com.timain.web.sys.service.UserService;
import com.timain.web.sys.utils.PinYinUtils;
import com.timain.web.sys.utils.WebUtils;
import com.timain.web.sys.vo.UserVO;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static cn.hutool.core.collection.CollUtil.toList;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 13:30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 查询用户总数
     * @return
     */
    @RequestMapping("findUserCount")
    public DataGridView findUserCount() {
        return new DataGridView(userService.findCount(), null);
    }

    /**
     * 条件分页查询所有用户信息
     * @param userVO
     * @return
     */
    @RequestMapping("findAllUsers")
    public DataGridView findAllUsers(UserVO userVO) {
        return userService.findAll(userVO);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("addUser")
    public ResultObj addUser(User user) {
        try {
            user.setType(Constants.USER_TYPE_NORMAL);
            Object salt = ByteSource.Util.bytes(user.getLoginName());
            user.setPassword(new Md5Hash(Constants.USER_DEFAULT_PWD, salt, 1024).toString());
            this.userService.saveOrUpdate(user);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 获取汉字的首字母
     * @param realName
     * @return
     */
    @RequestMapping("ChineseToPinYin")
    public Map<String, Object> ChineseToPinYin(String realName) {
        Map<String, Object> map = new HashMap<>();
        if (null!=realName) {
            map.put("value", PinYinUtils.getPinYin(realName));
        } else {
            map.put("value", "");
        }
        return map;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping("updateUser")
    public ResultObj updateUser(User user) {
        try {
            user.setType(Constants.USER_TYPE_NORMAL);
            Object salt = ByteSource.Util.bytes(user.getLoginName());
            user.setPassword(new Md5Hash(Constants.USER_DEFAULT_PWD, salt, 1024).toString());
            this.userService.saveOrUpdate(user);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping("deleteUser")
    public ResultObj deleteUser(Integer userId) {
        try {
            User user = this.userService.getUser(userId);
            if (user.getRealName().equals("超级管理员")) {
                return ResultObj.NOT_DELETE_SUPER;
            }
            this.userService.deleteUser(userId);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 重置密码
     * @param userId
     * @return
     */
    @RequestMapping("changePwd")
    public ResultObj changePwd(Integer userId) {
        try {
            User user = this.userService.getUser(userId);
            Object salt = ByteSource.Util.bytes(user.getLoginName());
            user.setPassword(new Md5Hash(Constants.USER_DEFAULT_PWD, salt, 1024).toString());
            this.userService.changePwd(user);
            return ResultObj.RESERT_PWD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.RESERT_PWD_ERROR;
        }
    }
    
    @RequestMapping("initRoleByUserId")
    public DataGridView initRoleByUserId(Integer userId) {
        //查询所有可用的角色列表
        List<Role> roleList = this.roleService.findAll(Constants.AVAILABLE_TRUE);
        Set<Role> roleSet = this.userService.findRolesByUserId(userId);
        Map<Object, Object> map = new LinkedHashMap<>();
        for (Role role : roleList) {
            map.put(role.getRoleId() - 1, role);
        }
        map.forEach((o, o2) -> {
            Role role = (Role) map.get(o);
            Boolean LAY_CHECKED = false;
            for (Role role1 : roleSet) {
                if (role1.getRoleId()==role.getRoleId()) {
                    LAY_CHECKED = true;
                    break;
                }
            }
            ((Role) map.get(o)).setLAY_CHECKED(LAY_CHECKED);
        });
        return new DataGridView(Long.valueOf(map.size()), map);
    }
}
