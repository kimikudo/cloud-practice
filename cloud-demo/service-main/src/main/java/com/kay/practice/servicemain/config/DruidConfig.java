package com.kay.practice.servicemain.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 数据源配置
 *
 * @author Kay
 * @date 2020-12-7
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
}
