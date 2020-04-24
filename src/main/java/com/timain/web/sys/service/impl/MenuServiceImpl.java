package com.timain.web.sys.service.impl;

import com.timain.web.sys.mapper.MenuMapper;
import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yyf
 * @Version 1.0
 * @Date 2020/4/22 0022 19:46
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<Menu> findAll() {
        return menuMapper.findAll();
    }

    /**
     * 查询所有菜单
     *
     * @param available
     * @return
     */
    @Override
    public List<Menu> findAllMenus(Integer available) {
        return menuMapper.findAllByAvailable(available);
    }
}
