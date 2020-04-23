package com.timain.web.sys.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/23 15:30
 */
@Data
@Entity
@Table(name = "sys_login_info")
public class LoginInfo implements Serializable {
    
    private static final long serialVersionUID = 7327508655246786137L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 登录IP
     */
    private String loginIp;
    /**
     * 登录时间
     */
    private Date loginTime;
}
