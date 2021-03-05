package com.kay.practice.servicemain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import com.kay.practice.servicemain.dao.police.ImsiSourceDataMapper;
import com.kay.practice.servicemain.entity.ImsiSourceData;
import com.kay.practice.servicemain.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ExcelServiceImpl extends ServiceImpl<ImsiSourceDataMapper, ImsiSourceData> implements ExcelService {
    @Override
    public List<ImsiSourceData> listData() {
        List<ImsiSourceData> list = this.list(
                new QueryWrapper<ImsiSourceData>()
                        .orderByDesc("report_time")
                        .last(" LIMIT 50")
        );
        return list;
    }

    @Override
    public void exportByExcel4J(HttpServletResponse response) throws IOException {
        List<ImsiSourceData> list = this.listData();
        //Excel4J方式导出
        try {
            ExcelUtils.getInstance().exportObjects2Excel(list, ImsiSourceData.class, "Excel4J导出测试_" + System.currentTimeMillis() + ".xlsx");
        } catch (Excel4JException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exportByPoi() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet1");
        //标题行
        HSSFRow headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("ID");
        headRow.createCell(1).setCellValue("IMSI");
        headRow.createCell(2).setCellValue("采集时间");
        headRow.createCell(3).setCellValue("运营商");

        //写数据
        List<ImsiSourceData> list = this.listData();
        int i = 1;
        for (ImsiSourceData imsiSourceData : list) {
            HSSFRow row = sheet.createRow(i);
            row.createCell(0).setCellValue(imsiSourceData.getId());
            row.createCell(1).setCellValue(imsiSourceData.getImsi());
            //时间戳字段的处理
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            row.createCell(2).setCellValue(format.format(new Date(imsiSourceData.getReportTime())));
            row.createCell(3).setCellValue(imsiSourceData.getNetworkOperator());
            i++;
        }
        FileOutputStream os = new FileOutputStream("POI导出_" + System.currentTimeMillis() + ".xls");
        workbook.write(os);
        os.flush();
        os.close();
    }
}
