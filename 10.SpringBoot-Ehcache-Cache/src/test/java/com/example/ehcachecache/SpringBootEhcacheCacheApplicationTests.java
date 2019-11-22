package com.example.ehcachecache;

import com.example.ehcachecache.domain.TbUser;
import com.example.ehcachecache.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {SpringBootEhcacheCacheApplication.class})
@Slf4j
class SpringBootEhcacheCacheApplicationTests {

    @Autowired
    private TbUserService tbUserService;

    @Test
    void contextLoads() {

        tbUserService.selectById(99L);

        TbUser tbUser = new TbUser();
        tbUser.setId(99L);
        tbUser.setLoginName("测试RedisCache");

        tbUserService.add(tbUser);

        tbUser = tbUserService.selectById(99L);

        tbUser.setEmail("666");
        tbUserService.update(tbUser);

        tbUserService.selectById(99L);

        tbUserService.delete(99L);

    }

}
