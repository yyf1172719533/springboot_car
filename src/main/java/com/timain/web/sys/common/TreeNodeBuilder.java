package com.timain.web.sys.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 14:50
 */
public class TreeNodeBuilder {

    /**
     * 将简单的集合变成有层级关系的集合
     * @param nodes
     * @param topPID
     * @return
     */
    public static List<TreeNode> builder(List<TreeNode> nodes, Integer topPID) {
        List<TreeNode> nodeList = new ArrayList<>();
        for (TreeNode n1 : nodes) {
            if (n1.getPId() == topPID) {
                nodeList.add(n1);
            }
            for (TreeNode n2 : nodes) {
                if (n2.getPId() == n1.getId()) {
                    n1.getChildren().add(n2);
                }
            }
        }
        return nodeList;
    }
}
