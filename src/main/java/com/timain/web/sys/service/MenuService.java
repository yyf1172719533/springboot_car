package com.timain.web.sys.service;

import com.timain.web.sys.pojo.Menu;

import java.util.List;

/**
 * @Author yyf
 * @Version 1.0
 * @Date 2020/4/22 0022 19:46
 */
public interface MenuService {
    
    List<Menu> findAll();

    /**
     * 查询所有菜单
     * @param available
     * @return
     */
    List<Menu> findAllMenus(Integer available);
}
