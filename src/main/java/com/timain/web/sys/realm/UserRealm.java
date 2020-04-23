package com.timain.web.sys.realm;

import com.timain.web.sys.common.Constants;
import com.timain.web.sys.dto.UserDTO;
import com.timain.web.sys.pojo.Menu;
import com.timain.web.sys.pojo.Role;
import com.timain.web.sys.pojo.User;
import com.timain.web.sys.service.MenuService;
import com.timain.web.sys.service.RoleService;
import com.timain.web.sys.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author yyf
 * @Version 1.0
 * @Date 2020/4/22 0022 19:19
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 授权
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("授权");
        UserDTO userDTO = (UserDTO) principal.getPrimaryPrincipal();
        User user = userDTO.getUser();
        List<String> menus = userDTO.getMenus();
        List<Menu> menuList = this.menuService.findAll();
        List<String> menuLists = new ArrayList<>();
        for (Menu menu : menuList) {
            menuLists.add(menu.getTitle());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (user.getType() == Constants.USER_TYPE_SUPER) {
            info.addStringPermissions(menuLists);
        } else {
            if (null!=menus && menus.size()>0) {
                info.addStringPermissions(menus);
            }
        }
        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");
        String loginName = token.getPrincipal().toString();
        User user = this.userService.findByName(loginName);
        if (null!=user) {
            //关联角色
            Set<Role> roleSet = this.userService.findRolesByUserId(user.getUserId());
            List<String> roles = new ArrayList<>();
            for (Role role : roleSet) {
                roles.add(role.getRoleName());
            }
            //关联菜单权限
            List<String> menus = new ArrayList<>();
            for (Role role : roleSet) {
                Set<Menu> menuSet = this.roleService.findMenusByRoleId(role.getRoleId());
                for (Menu menu : menuSet) {
                    menus.add(menu.getTitle());
                }
            }
            UserDTO userDTO = new UserDTO(user, roles, menus);
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getLoginName());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDTO, user.getPassword(), credentialsSalt, this.getName());
            return info;
        }
        return null;
    }
}
