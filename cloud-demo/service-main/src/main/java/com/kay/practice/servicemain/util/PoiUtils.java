package com.kay.practice.servicemain.util;

import com.kay.practice.servicemain.constant.ExcelConstant;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * POI导出工具类
 * <p>
 * TODO 工具类方法实现待完成
 *
 * @author Kay
 * @date 2020-10-30
 */
public class PoiUtils {
    /**
     * 表格初始化
     *
     * @param totalRowCount 总行数,即总记录数
     * @param titles        表头,用于初始化每个sheet
     * @return
     */
    public static SXSSFWorkbook initExcel(Integer totalRowCount, String[] titles) {
        //初始化参数表示内存中容纳的行数
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        //计算sheet数量
        Integer sheetCount = (totalRowCount % ExcelConstant.PER_SHEET_ROW_COUNT) == 0 ?
                (totalRowCount % ExcelConstant.PER_SHEET_ROW_COUNT) : (totalRowCount % ExcelConstant.PER_SHEET_ROW_COUNT + 1);
        //循环创建sheet
        for (int i = 0; i < totalRowCount; i++) {
            SXSSFSheet sheet = workbook.createSheet("sheet" + (i + 1));
            //创建标题行,并写入列名
            SXSSFRow headRow = sheet.createRow(0);
            for (int j = 0; j < titles.length; j++) {
                SXSSFCell cell = headRow.createCell(j);
                cell.setCellValue(titles[j]);
            }
        }
        return workbook;
    }

    /**
     * 导出表格到本地文件
     */
    public static void exportExcelToPath() {

    }

    /**
     * 导出表格到流
     */
    public static void exportExcelToStream() {

    }

    /**
     * 保存文件至指定本地路径
     *
     * @param workbook Excel文件
     * @param path     保存路径
     * @param fileName 文件名
     */
    public static void saveToLocalPath(SXSSFWorkbook workbook, String path, String fileName) {
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(path + fileName);
            workbook.write(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != workbook) {
                workbook.dispose();
            }
            if (null != output) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 保存文件至流
     *
     * @param workbook Excel文件
     * @param response
     * @param fileName 文件名.
     */
    public static void saveToStream(SXSSFWorkbook workbook, HttpServletResponse response, String fileName) {
        try {
            response.setHeader("Content-disposition", "attachment; filename="
                    + new String((fileName + ".xlsx").getBytes("utf-8"), "ISO8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
