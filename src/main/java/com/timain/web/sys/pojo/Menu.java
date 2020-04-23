package com.timain.web.sys.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Author yyf
 * @Version 1.0
 * @Date 2020/4/22 0022 19:39
 */
@Data
@Entity
@Table(name = "sys_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = -4982379745228645854L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 父级ID
     */
    @Column(name = "pid")
    private Integer pId;
    /**
     * 菜单名称
     */
    private String title;
    /**
     * 菜单路径
     */
    private String href;
    /**
     * 是否展开 0-不展开 1-展开
     */
    private Integer spread;
    /**
     * 打开方式
     */
    private String target;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否可用
     */
    private Integer available;

}
