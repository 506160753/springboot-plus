package com.example.mybatis.config;

import com.example.mybatis.domain.TbUser;
import lombok.Data;

/**
 * @author Administrator
 * @date 2019/12/2 10:31
 */
@Data
public class UserDetail extends TbUser {

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;
}
