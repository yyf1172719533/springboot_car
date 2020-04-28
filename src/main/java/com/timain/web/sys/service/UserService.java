package com.timain.web.sys.service;

import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.pojo.Role;
import com.timain.web.sys.pojo.User;
import com.timain.web.sys.vo.UserVO;

import java.util.List;
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

    /**
     * 查询用户总数
     * @return
     */
    Long findCount();

    /**
     * 根据用户ID查询拥有菜单
     * @param userId
     * @return
     */
    Set<Menu> findMenusByUserId(Integer userId);

    /**
     * 根据用户ID查询所有可用菜单
     * @param userId
     * @return
     */
    List<Menu> findMenusAvailable(Integer userId);

    /**
     * 条件分页查询用户信息
     * @param userVO
     * @return
     */
    DataGridView findAll(UserVO userVO);
}
