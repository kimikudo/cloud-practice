package com.kay.practice.servicemain.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 主数据源配置
 *
 * @author Kay
 * @date 2021-03-09
 */
@Configuration
@MapperScan(basePackages = "com.kay.practice.servicemain.dao.practice", sqlSessionTemplateRef = "practiceSqlSessionTemplate")
public class PracticeDataSourceConfig {
    //参考https://www.cnblogs.com/ccsert/p/12249252.html

    @Bean(name = "practiceSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("practiceDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/practice/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "practiceTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("practiceDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "practiceSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("practiceSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
