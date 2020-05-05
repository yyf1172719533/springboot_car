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
    public static final ResultObj LOGOUT_ERROR = new ResultObj(Constants.ERROR, "退出失败");
    
    public static final ResultObj ADD_SUCCESS = new ResultObj(Constants.OK, "添加成功");
    public static final ResultObj ADD_ERROR = new ResultObj(Constants.ERROR, "添加失败");

    public static final ResultObj UPDATE_SUCCESS = new ResultObj(Constants.OK, "修改成功");
    public static final ResultObj UPDATE_ERROR = new ResultObj(Constants.ERROR, "修改失败");

    public static final ResultObj DELETE_SUCCESS = new ResultObj(Constants.OK, "删除成功");
    public static final ResultObj DELETE_ERROR = new ResultObj(Constants.ERROR, "删除失败");
    public static final ResultObj NOT_DELETE_SUPER = new ResultObj(Constants.ERROR, "不能删除超级管理员");
    
    public static final ResultObj RESERT_PWD_SUCCESS = new ResultObj(Constants.OK, "重置密码成功");
    public static final ResultObj RESERT_PWD_ERROR = new ResultObj(Constants.ERROR, "重置密码失败");
}
