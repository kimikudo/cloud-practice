package com.kay.practice.servicemain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kay.practice.servicemain.entity.ImsiSourceData;

import javax.servlet.http.HttpServletResponse;

/**
 * Excel导出业务层接口
 *
 * @author Kay
 * @date 2020-10-26
 */
public interface ExcelService extends IService<ImsiSourceData> {

    /**
     * Excel4J方式导出
     */
    void exportByExcel4J(HttpServletResponse httpServletResponse);

}
