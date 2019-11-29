package com.example.mybatis.shiro;

import com.example.mybatis.domain.TbPermission;
import com.example.mybatis.domain.TbRole;
import com.example.mybatis.domain.TbUser;
import com.example.mybatis.service.TbUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private TbUserService tbUserService;

    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        TbUser user = (TbUser) SecurityUtils.getSubject().getPrincipal();
        String loginName = user.getLoginName();

        System.out.println("用户" + loginName + "获取权限-----ShiroRealm.doGetAuthorizationInfo");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取用户角色集
        List<TbRole> roleList = tbUserService.findRoleByUserId(user.getId());
        Set<String> roleSet = new HashSet<>();
        for (TbRole r : roleList) {
            roleSet.add(r.getCode());
        }
        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集
        List<TbPermission> permissionList = tbUserService.findPermissionByUserId(user.getId());
        Set<String> permissionSet = new HashSet<>();
        for (TbPermission p : permissionList) {
            permissionSet.add(p.getPermission());
        }
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        TbUser user = tbUserService.findByUserName(userName);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (user.getState() == 1) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }

}
