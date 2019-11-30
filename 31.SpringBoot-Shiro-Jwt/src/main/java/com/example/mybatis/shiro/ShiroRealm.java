package com.example.mybatis.shiro;

import com.example.mybatis.jwt.JWTToken;
import com.example.mybatis.domain.TbPermission;
import com.example.mybatis.domain.TbRole;
import com.example.mybatis.domain.TbUser;
import com.example.mybatis.jwt.JWTUtil;
import com.example.mybatis.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private TbUserService tbUserService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
        String username = JWTUtil.getUsername(token.toString());
        TbUser user = tbUserService.findByUserName(username);

        System.out.println("用户" + username + "获取权限-----ShiroRealm.doGetAuthorizationInfo");
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
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 这里的 token是从 JWTFilter 的 executeLogin 方法传递过来的，已经经过了解密
        String token = (String) authenticationToken.getCredentials();
        String username = JWTUtil.getUsername(token);
        System.out.println("用户" + username + "认证-----ShiroRealm.doGetAuthenticationInfo");

        if (StringUtils.isBlank(username)) {
            throw new AuthenticationException("token校验不通过");
        }
        TbUser user = tbUserService.findByUserName(username);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (user == null) {
            throw new AuthenticationException("用户名或密码错误");
        }
        if (!JWTUtil.verify(token, username, user.getPassword())) {
            throw new AuthenticationException("token校验不通过");
        }
        if (user.getState() == 1) {
            throw new AuthenticationException("账号已被锁定,请联系管理员！");
        }
        return new SimpleAuthenticationInfo(token, token, "shiro_realm");
    }

}
