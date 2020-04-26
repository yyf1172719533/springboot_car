package com.timain.web.sys.controller;

import com.timain.web.sys.common.Constants;
import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.common.TreeNode;
import com.timain.web.sys.common.TreeNodeBuilder;
import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.pojo.User;
import com.timain.web.sys.service.MenuService;
import com.timain.web.sys.service.UserService;
import com.timain.web.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/23 16:47
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    
    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userService;
    
    @RequestMapping("loadAllMenus")
    public DataGridView findAllMenus() {
        User user = (User) WebUtils.getSession().getAttribute("user");
        List<Menu> menuList = null;
        if (user.getType() == Constants.USER_TYPE_SUPER) {
            menuList = this.menuService.findAllMenus(Constants.AVAILABLE_TRUE);
        } else {
            menuList = this.userService.findMenusAvailable(user.getUserId());
        }

        List<TreeNode> nodeList = new ArrayList<>();
        //将menuList集合中的数据放入nodeList中
        for (Menu menu : menuList) {
            Integer id = menu.getId();
            Integer pId = menu.getPId();
            String title = menu.getTitle();
            String icon = menu.getIcon();
            String href = menu.getHref();
            Boolean spread = menu.getSpread()==Constants.SPREAD_TRUE?true:false;
            String target = menu.getTarget();
            nodeList.add(new TreeNode(id, pId, title, icon, href, spread, target));
        }
        List<TreeNode> nodes = TreeNodeBuilder.builder(nodeList, 1);
        return new DataGridView(nodes);
    }
}
