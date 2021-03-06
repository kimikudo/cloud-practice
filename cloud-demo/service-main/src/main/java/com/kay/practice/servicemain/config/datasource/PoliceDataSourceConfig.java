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
 * 第二数据源配置
 *
 * @author Kay
 * @date 2021-03-09
 */
@Configuration
@MapperScan(basePackages = "com.kay.practice.servicemain.dao.police", sqlSessionTemplateRef = "policeSqlSessionTemplate")
public class PoliceDataSourceConfig {
    @Bean(name = "policeSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("policeDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/police/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "policeTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("policeDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "policeSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("policeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
