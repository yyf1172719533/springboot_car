package com.timain.web.sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/23 14:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {
    
    private Integer code;
    private String msg;
    
    public static final ResultObj LOGIN_SUCCESS = new ResultObj(Constants.OK, "登录成功");
    public static final ResultObj LOGIN_ERROR_NAME_OR_PWD = new ResultObj(Constants.ERROR, "用户名或密码错误");

    public static final ResultObj LOGOUT_SUCCESS = new ResultObj(Constants.OK, "退出成功");
    public static final ResultObj LOGOUT_ERROR = new ResultObj(Constants.OK, "退出失败");
}