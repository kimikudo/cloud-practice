package com.kay.practice.servicemain.service.impl;

import com.kay.practice.servicemain.dao.police.ImsiSourceDataMapper;
import com.kay.practice.servicemain.dao.practice.UserMapper;
import com.kay.practice.servicemain.entity.ImsiSourceData;
import com.kay.practice.servicemain.entity.User;
import com.kay.practice.servicemain.service.DruidTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Druid多数据源测试
 *
 * @author Kay
 * @date 2021-03-05
 */
@Service("druidTestService")
public class DruidTestServiceImpl implements DruidTestService {

    @Autowired
    private ImsiSourceDataMapper imsiSourceDataMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<ImsiSourceData> listImsi() {
        return imsiSourceDataMapper.listLatestImsi();
    }

    @Override
    public List<User> listUser() {
        return userMapper.listAll();
    }
}
