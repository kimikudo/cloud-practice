package com.kay.practice.servicemain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kay.practice.servicemain.dao.ImsiSourceDataMapper;
import com.kay.practice.servicemain.entity.ImsiSourceData;
import com.kay.practice.servicemain.service.ExcelService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class ExcelServiceImpl extends ServiceImpl<ImsiSourceDataMapper,ImsiSourceData> implements ExcelService {
    @Override
    public void exportByExcel4J(HttpServletResponse httpServletResponse) {
        List<ImsiSourceData> list = this.list(
                new QueryWrapper<ImsiSourceData>()
                        .orderByDesc("report_time")
                        .last(" LIMIT 50")
        );

        
    }
}
