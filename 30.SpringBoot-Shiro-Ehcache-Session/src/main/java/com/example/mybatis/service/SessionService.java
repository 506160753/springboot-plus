package com.example.mybatis.service;


import com.example.mybatis.domain.UserOnline;

import java.util.List;

public interface SessionService {

    List<UserOnline> list();

    boolean forceLogout(String sessionId);
}
