package com.example.mybatis.config;

import com.example.mybatis.domain.TbRole;
import com.example.mybatis.domain.TbUser;
import com.example.mybatis.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TbUserService tbUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 模拟一个用户，替代数据库获取逻辑
        TbUser tbUser = tbUserService.findByUserName(username);

        UserDetail user = new UserDetail();
        user.setLoginName(username);
        user.setPassword(this.passwordEncoder.encode("123456"));
        // 输出加密后的密码
        System.out.println(user.getPassword());

        List<TbRole> roles = tbUserService.findRoleByUserId(tbUser.getId());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (TbRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        return new User(username, user.getPassword(), user.isEnabled(),
                user.isAccountNonExpired(), user.isCredentialsNonExpired(),
                user.isAccountNonLocked(), authorities);
    }
}
