package com.kay.practice.servicemain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kay.practice.servicemain.entity.ImsiSourceData;
import com.kay.practice.servicemain.entity.User;

import java.util.List;

/**
 * Druid多数据源测试
 *
 * @author Kay
 * @date 2021-03-05
 */
public interface DruidTestService {

    /**
     * 获取最新IMSI
     * @return
     */
    List<ImsiSourceData> listImsi();

    /**
     * 获取全部用户
     * @return
     */
    List<User> listUser();
}
