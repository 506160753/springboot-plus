package com.example.ehcachecache.service;


import com.example.ehcachecache.domain.TbUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * <p>
 * 用户表：包括三个或以上字段，ID，用户名，对该用户的描述，其它(如地址、电话等信息) 服务类
 * </p>
 *
 * @author Administrator
 * @since 2019-03-10
 */
@CacheConfig(cacheNames = "cache")
public interface TbUserService {

    @Cacheable(key = "#p0", unless = "#result == null")
    TbUser selectById(Long id);

    int add(TbUser tbUser);

    @CachePut(key = "#p0.id")
    TbUser update(TbUser tbUser);

    @CacheEvict(key = "#p0", condition = "#p0!='1'")
    int delete(Long id);
}
