package com.timain.web.bus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/5/19 10:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bus_customer")
public class Customer implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 身份证
     */
    private String identity;
    /**
     * 客户姓名
     */
    private String customerName;
    private Integer sex;
    private String address;
    private String phone;
    /**
     * 职位
     */
    private String career;
    private Date createTime;
}
