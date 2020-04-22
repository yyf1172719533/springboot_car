package com.timain.web.sys.pojo;

import lombok.Data;

import javax.persistence.*;



/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/22 16:00
 */
@Data
@Entity
@Table(name = "sys_user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 特征
     */
    private String identity;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 性别 0-女  1-男
     */
    private Integer sex;
    /**
     * 地址
     */
    private String address;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 密码
     */
    private String password;
    /**
     * 地位
     */
    private String position;
    /**
     * 类型 1-超级管理员  2-普通用户
     */
    private Integer type;
    /**
     * 是否可用
     */
    private Integer available;
}
