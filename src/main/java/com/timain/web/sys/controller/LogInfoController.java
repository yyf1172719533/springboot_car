package com.timain.web.sys.controller;

import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.common.ResultObj;
import com.timain.web.sys.service.LoginInfoService;
import com.timain.web.sys.vo.LogInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/28 9:07
 */
@RequestMapping("/logInfo")
@RestController
public class LogInfoController {
    
    @Autowired
    private LoginInfoService loginInfoService;

    /**
     * 条件分页查询所有登录日志信息
     * @param logInfoVO
     * @return
     */
    @RequestMapping("findLogInfo")
    public DataGridView findLogInfo(LogInfoVO logInfoVO) {
        return this.loginInfoService.findAllInfos(logInfoVO);
    }

    /**
     * 根据ID删除登录日志信息
     * @param id
     * @return
     */
    @RequestMapping("deleteOneInfos")
    public ResultObj deleteOneInfos(Integer id) {
        try {
            this.loginInfoService.deleteInfos(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    
    @RequestMapping("deleteMoreInfos")
    public ResultObj deleteMoreInfos(LogInfoVO logInfoVO) {
        try {
            Integer[] ids = logInfoVO.getIds();
            for (Integer id : ids) {
                this.loginInfoService.deleteInfos(id);
            }
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
