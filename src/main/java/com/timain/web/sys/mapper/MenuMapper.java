package com.timain.web.sys.mapper;

import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.vo.MenuVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author yyf
 * @Version 1.0
 * @Date 2020/4/22 0022 19:45
 */
public interface MenuMapper extends JpaRepository<Menu, Integer> {

    /**
     * 根据条件查询菜单
     * @param available
     * @return
     */
    List<Menu> findAllByAvailable(Integer available);
    
    
}
