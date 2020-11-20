package com.kay.practice.servicemain.service;

import org.apache.poi.xssf.streaming.SXSSFSheet;

/**
 * @author Kay
 * @description 写数据委托类
 * @date 2020-11-12
 */
public interface WriteExcelDataDelegated {
    /**
     * 向Excel中写入数据
     *
     * @param sheet       指定Sheet
     * @param startRow    开始行
     * @param endRow      结束行
     * @param currentPage 分页查询起始页
     * @param pageSize    每页数据量
     * @throws Exception
     */
    void writeData(SXSSFSheet sheet, Integer startRow, Integer endRow, Integer currentPage, Integer pageSize) throws Exception;
}
