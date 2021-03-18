package com.kay.practice.servicemain.config.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 多数据源配置类
 *
 * @author Kay
 * @date 2021-03-09
 */
@Configuration
public class MultiDataSourceConfig {
    @Primary
    @Bean("practiceDataSource")
    @ConfigurationProperties("spring.datasource.druid.practice")
    public DataSource practiceDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("policeDataSource")
    @ConfigurationProperties("spring.datasource.druid.police")
    public DataSource policeDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

}
