package com.kay.practice.servicemain.common;

import com.github.crab2died.converter.WriteConvertible;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * crab2died.ExcelUtils生成表格使用的格式化日期时间的转换器
 * @ClassName DateTimeConverter
 * @Author mayue
 * @Date 2020/4/13 16:00
 * @Version 1.0
 */
public class DateTimeConverter implements WriteConvertible {
    @Override
    public Object execWrite(Object o) {
        if (o instanceof Date) {
            Date date = (Date) o;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = format.format(date);
            return dateStr;
        }
        return o;
    }
}
