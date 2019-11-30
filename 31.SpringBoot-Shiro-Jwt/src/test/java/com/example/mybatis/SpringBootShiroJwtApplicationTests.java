package com.example.mybatis;

import org.apache.shiro.codec.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

//@SpringBootTest
class SpringBootShiroJwtApplicationTests {

    @Test
    void contextLoads() {
        byte[] b = Base64.decode("3AvVhmFLUs0KTA3Kprsdag==");
        try {
            String s = new String(b, "utf-8");
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
