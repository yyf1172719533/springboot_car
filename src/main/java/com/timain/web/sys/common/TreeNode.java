package com.timain.web.sys.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 14:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode implements Serializable {

    private static final long serialVersionUID = 5478706449305402694L;
    
    private Integer id;
    @JsonProperty("parentId")
    private Integer pId;
    private String title;
    private String icon;
    private String href;
    private Boolean spread;
    private String target;
    private List<TreeNode> children = new ArrayList<>();
    
    private String checkArr = "0"; //0-未选中 1-选中

    /**
     * 首页左边的导航树
     * @param id
     * @param pId
     * @param title
     * @param icon
     * @param href
     * @param spread
     * @param target
     */
    public TreeNode(Integer id, Integer pId, String title, String icon, String href, Boolean spread, String target) {
        this.id = id;
        this.pId = pId;
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
        this.target = target;
    }

    /**
     * dtree复选树
     * @param id
     * @param pId
     * @param title
     * @param spread
     * @param checkArr
     */
    public TreeNode(Integer id, Integer pId, String title, Boolean spread, String checkArr) {
        this.id = id;
        this.pId = pId;
        this.title = title;
        this.spread = spread;
        this.checkArr = checkArr;
    }
}
