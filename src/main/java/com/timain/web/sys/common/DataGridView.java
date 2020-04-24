package com.timain.web.sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装layui数据表格的数据对象
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 9:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView {
    
    private Integer code = 0;
    private String msg = "";
    private Long count;
    private Object data;

    public DataGridView(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public DataGridView(Object data) {
        this.data = data;
    }
}
