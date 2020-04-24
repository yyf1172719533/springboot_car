package com.timain.web.sys.mapper;

import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.vo.MenuVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 14:21
 */
@SpringBootTest
class MenuMapperTest {
    
    @Autowired
    private MenuMapper menuMapper;

    @Test
    void findAllByAvailable() {
        List<Menu> menuList = menuMapper.findAllByAvailable(1);
        for (Menu menu : menuList) {
            System.out.println(menu);
        }
    }
}