package com.timain.web.sys.vo;

import com.timain.web.sys.pojo.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 9:28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleVO extends Role {
    
    private static final long serialVersionUID = -2605597468467769369L;
    
    private Integer page = 1;
    private Integer limit = 10;
    
}
