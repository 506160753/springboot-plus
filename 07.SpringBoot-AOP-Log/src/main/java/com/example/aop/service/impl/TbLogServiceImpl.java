package com.example.aop.service.impl;

import com.example.aop.domain.TbLog;
import com.example.aop.mapper.TbLogMapper;
import com.example.aop.service.TbLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @date 2019/11/21 12:50
 */
@Service
public class TbLogServiceImpl implements TbLogService {

    @Autowired
    private TbLogMapper tbLogMapper;

    @Override
    public void insert(TbLog tbLog) {
        tbLogMapper.insert(tbLog);
    }
}
