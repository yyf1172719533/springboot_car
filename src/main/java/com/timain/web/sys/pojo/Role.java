package com.timain.web.sys.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @Author yyf
 * @Version 1.0
 * @Date 2020/4/22 0022 19:03
 */
@Data
@Entity
@Table(name = "sys_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 5263926172475040885L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 是否可用
     */
    private Integer available;

    @ManyToMany(targetEntity = Menu.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "sys_role_menu", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "roleId")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "id")})
    private Set<Menu> menus;
    
    @Transient
    private Boolean LAY_CHECKED;
}
