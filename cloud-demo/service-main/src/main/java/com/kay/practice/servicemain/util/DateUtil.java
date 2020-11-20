package com.kay.practice.servicemain.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author Kay
 * @date 2020-11-16
 */
public class DateUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String dateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.DATE_FORMAT);
        return format.format(date);
    }

}
