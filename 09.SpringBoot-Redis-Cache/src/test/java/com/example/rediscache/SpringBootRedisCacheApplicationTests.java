package com.example.rediscache;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.rediscache.domain.TbUser;
import com.example.rediscache.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {SpringBootRedisCacheApplication.class})
@Slf4j
class SpringBootRedisCacheApplicationTests {

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
