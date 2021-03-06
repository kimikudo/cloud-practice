package com.kay.practice.servicemain.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 数据源配置
 *
 * @author Kay
 * @date 2020-12-7
 */
//@Configuration
public class DruidConfig {

    /**
     * 数据源配置
     *
     * @return
     */
    //@ConfigurationProperties(prefix = "spring.datasource.druid")
    //@Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 注册一个StatViewServlet
     *
     * @return
     */
    //@Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //添加初始化参数
        //白名单,若不配置或配置为空则表示允许所有地址访问
        //servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //IP黑名单,与allow同时存在时,deny优先于allow
        //servletRegistrationBean.addInitParameter("deny","192.168.2.74");
        //登录查看信息的账号密码
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * druid过滤器
     *
     * @return
     */
    //@Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


}
