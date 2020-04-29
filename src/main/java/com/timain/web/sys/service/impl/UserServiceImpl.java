package com.timain.web.sys.service.impl;

import com.timain.web.sys.common.Constants;
import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.mapper.UserMapper;
import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.pojo.Role;
import com.timain.web.sys.pojo.User;
import com.timain.web.sys.service.RoleService;
import com.timain.web.sys.service.UserService;
import com.timain.web.sys.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.*;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/22 16:17
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private RoleService roleService;

    /**
     * 根据登录名查询用户对象
     *
     * @param loginName
     * @return
     */
    @Override
    public User findByName(String loginName) {
        return userMapper.findByLoginName(loginName);
    }

    /**
     * 根据用户ID查询用户角色
     *
     * @param userId
     * @return
     */
    @Override
    public Set<Role> findRolesByUserId(Integer userId) {
        Optional<User> optional = userMapper.findById(userId);
        return optional.get().getRoles();
    }

    /**
     * 查询用户总数
     *
     * @return
     */
    @Override
    public Long findCount() {
        return userMapper.count();
    }

    /**
     * 根据用户ID查询拥有菜单
     *
     * @param userId
     * @return
     */
    @Override
    public Set<Menu> findMenusByUserId(Integer userId) {
        Set<Menu> menuSet = new HashSet<>();
        Set<Role> roleSet = findRolesByUserId(userId);
        for (Role role : roleSet) {
            menuSet = this.roleService.findMenusByRoleId(role.getRoleId());
        }
        return menuSet;
    }

    /**
     * 根据用户ID查询所有可用菜单
     *
     * @param userId
     * @return
     */
    @Override
    public List<Menu> findMenusAvailable(Integer userId) {
        List<Menu> menuList = new ArrayList<>();
        Set<Menu> menuSet = findMenusByUserId(userId);
        for (Menu menu : menuSet) {
            if (menu.getAvailable() == Constants.AVAILABLE_TRUE) {
                menuList.add(menu);
            }
        }
        return menuList;
    }

    /**
     * 条件分页查询用户信息
     *
     * @param userVO
     * @return
     */
    @Override
    public DataGridView findAll(UserVO userVO) {
        PageRequest pageRequest = PageRequest.of(userVO.getPage() - 1, userVO.getLimit());
        Page<User> page = this.userMapper.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (null!=userVO.getRealName() && userVO.getRealName()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("realName"), "%" + userVO.getRealName() + "%"
                                )
                        )
                );
            }
            if (null!=userVO.getLoginName() && userVO.getLoginName()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("loginName"), "%" + userVO.getLoginName() + "%"
                                )
                        )
                );
            }
            if (null!=userVO.getAddress() && userVO.getAddress()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("address"), "%" + userVO.getAddress() + "%"
                                )
                        )
                );
            }
            if (null!=userVO.getPosition() && userVO.getPosition()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("position"), "%" + userVO.getPosition() + "%"
                                )
                        )
                );
            }
            return criteriaBuilder.and(
                    predicateList.toArray(new Predicate[predicateList.size()])
            );
        }, pageRequest);
        return new DataGridView(page.getTotalElements(), page.getContent());
    }

    /**
     * 添加或修改用户
     *
     * @param user
     */
    @Override
    public void saveOrUpdate(User user) {
        this.userMapper.save(user);
    }

    /**
     * 根据ID删除用户
     *
     * @param userId
     */
    @Override
    public void deleteUser(Integer userId) {
        this.userMapper.deleteById(userId);
    }

    /**
     * 根据ID重置用户密码
     *
     * @param user
     */
    @Override
    public void changePwd(User user) {
        this.userMapper.saveAndFlush(user);
    }

    /**
     * 根据ID查询用户
     *
     * @param userId
     * @return
     */
    @Override
    public User getUser(Integer userId) {
        return this.userMapper.findById(userId).get();
    }

}
