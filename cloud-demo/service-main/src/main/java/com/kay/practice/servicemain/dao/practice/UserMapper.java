package com.kay.practice.servicemain.dao.practice;

import com.kay.practice.servicemain.entity.User;

import java.util.List;

/**
 * 系统用户数据层
 *
 * @author Kay
 * @date 2021-03-05
 */
public interface UserMapper {

    /**
     * 获取全部用户,测试用
     * @return
     */
    List<User> listAll();
}
