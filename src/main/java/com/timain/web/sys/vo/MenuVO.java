package com.timain.web.sys.vo;

import com.timain.web.sys.pojo.Menu;
import lombok.Data;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 14:20
 */
@Data
public class MenuVO extends Menu {
    
    private static final long serialVersionUID = -6538831086015683327L;
    
    private Integer page = 1;
    private Integer limit = 10;
}
