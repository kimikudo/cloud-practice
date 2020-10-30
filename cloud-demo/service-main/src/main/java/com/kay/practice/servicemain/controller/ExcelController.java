package com.kay.practice.servicemain.controller;

import com.kay.practice.servicemain.service.ExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Excel导出控制器
 *
 * @author Kay
 * @date 2020-10-23
 */
@RestController
@RequestMapping(value = "/excel")
@Api(tags = "Excel导出控制器")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @GetMapping("/exportExcel4J")
    @ApiOperation(value = "Excel4J导出",notes = "导出为文件")
    public void exportExcel4J(HttpServletResponse response){
        try {
            excelService.exportByExcel4J(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/exportPOI")
    @ApiOperation(value = "POI导出",notes = "导出为文件")
    public void exportPOI(){
        try {
            excelService.exportByPoi();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
