package com.kay.practice.servicemain.dao.police;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kay.practice.servicemain.entity.ImsiSourceData;

import java.util.List;

/**
 * IMSI源数据数据层
 *
 * @author Kay
 * @date 2020-10-26
 */
public interface ImsiSourceDataMapper extends BaseMapper<ImsiSourceData> {

    /**
     * 查询最新的20条IMSI记录,测试用
     * @return
     */
    List<ImsiSourceData> listLatestImsi();

}
