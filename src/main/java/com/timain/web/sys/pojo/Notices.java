package com.timain.web.sys.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 公告实体类
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 9:07
 */
@Data
@Table(name = "sys_notices")
@Entity
public class Notices implements Serializable {
    
    private static final long serialVersionUID = 4710454384998350131L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 公告名称
     */
    private String title;
    /**
     * 公告内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 操作员
     */
    private String operName;
}
