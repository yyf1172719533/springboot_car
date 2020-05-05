package com.timain.web.sys.mapper;

import com.timain.web.sys.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Map;


/**
 * @Author yyf
 * @Version 1.0
 * @Date 2020/4/22 0022 19:13
 */
public interface RoleMapper extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {

    /**
     * 根据available查询角色列表
     * @param available
     * @return
     */
    List<Role> findAllByAvailable(Integer available);

}
