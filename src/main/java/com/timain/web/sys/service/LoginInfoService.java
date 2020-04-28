package com.timain.web.sys.service;

import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.pojo.LoginInfo;
import com.timain.web.sys.vo.LogInfoVO;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/23 15:35
 */
public interface LoginInfoService {

    /**
     * 添加登录日志
     * @param loginInfo
     */
    void save(LoginInfo loginInfo);

    /**
     * 条件分页查询所有登录日志信息
     * @param logInfoVO
     * @return
     */
    DataGridView findAllInfos(LogInfoVO logInfoVO);

    /**
     * 根据ID删除登录日志信息
     * @param id
     */
    void deleteInfos(Integer id);
}
