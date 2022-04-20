package com.lzf.shirojwt.shiro.realm;

import com.lzf.shirojwt.model.JwtToken;
import com.lzf.shirojwt.model.Permission;
import com.lzf.shirojwt.model.Role;
import com.lzf.shirojwt.model.User;
import com.lzf.shirojwt.service.RoleService;
import com.lzf.shirojwt.service.UserService;
import com.lzf.shirojwt.utils.ApplicationContextUtils;
import com.lzf.shirojwt.utils.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author zongfang
 * @date 2022/4/19
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String principal = (String)principals.getPrimaryPrincipal();
        Integer id;
        try {
            id = JwtUtils.getId(principal);
        }catch (Exception e){
            return null;
        }
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
        RoleService roleService = (RoleService) ApplicationContextUtils.getBean("roleService");
        List<Role> roles = userService.findRoleById(id);
        if(!CollectionUtils.isEmpty(roles)){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            roles.forEach(role->{
                simpleAuthorizationInfo.addRole(role.getRole());
                List<Permission> perms = roleService.findPermissionById(role.getId());
                if(!CollectionUtils.isEmpty(perms)){
                    perms.forEach(perm -> {
                        simpleAuthorizationInfo.addStringPermission(perm.getPermission());
                    });
                }
            });
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        if(JwtUtils.verify(principal)){
            return new SimpleAuthenticationInfo(principal, principal, this.getName());
        }
        return null;
    }
}
