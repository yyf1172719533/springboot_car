package com.timain.web.sys.service.impl;

import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.mapper.LoginInfoMapper;
import com.timain.web.sys.service.LoginInfoService;
import com.timain.web.sys.vo.LogInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/28 9:02
 */
@SpringBootTest
class LoginInfoServiceImplTest {
    
    @Autowired
    private LoginInfoMapper loginInfoMapper;
    @Autowired
    private LoginInfoService loginInfoService;

    @Test
    void save() {
    }

    @Test
    void findAllInfos() {
        LogInfoVO logInfoVO = new LogInfoVO();
        DataGridView dataGridView = this.loginInfoService.findAllInfos(logInfoVO);
        System.out.println(dataGridView);
    }
}