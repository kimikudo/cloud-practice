package com.kay.practice.servicemain.constant;

/**
 * Excel导出常量参数
 *
 * @author Kay
 * @date 2020-11-5
 */
public class ExcelConstant {

    /**
     * 每个sheet的行数
     */
    public static final Integer PER_SHEET_ROW_COUNT = 1000000;

    /**
     * 单次向Excel写入的记录数,即分页查询的每页记录数
     */
    public static final Integer PER_WRITE_ROW_COUNT = 200000;

    /**
     * 每个sheet的写入次数
     */
    public static final Integer PER_SHEET_WRITE_COUNT = PER_SHEET_ROW_COUNT / PER_WRITE_ROW_COUNT;

}
