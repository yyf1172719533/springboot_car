package com.timain.web.sys.service.impl;

import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.mapper.RoleMapper;
import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.pojo.Role;
import com.timain.web.sys.service.RoleService;
import com.timain.web.sys.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
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

    /**
     * 分页条件查询角色列表
     *
     * @param roleVO
     * @return
     */
    @Override
    public DataGridView queryAllBySome(RoleVO roleVO) {
        PageRequest pageRequest = PageRequest.of(roleVO.getPage() - 1, roleVO.getLimit());
        Page<Role> page = this.roleMapper.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (null!=roleVO.getRoleName() && roleVO.getRoleName()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("roleName"), "%" + roleVO.getRoleName() + "%"
                                )
                        )
                );
            }
            if (null!=roleVO.getRoleDesc() && roleVO.getRoleDesc()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("roleDesc"), "%" + roleVO.getRoleDesc() + "%"
                                )
                        )
                );
            }
            if (null!=roleVO.getAvailable()) {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("available"), roleVO.getAvailable()
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
}
