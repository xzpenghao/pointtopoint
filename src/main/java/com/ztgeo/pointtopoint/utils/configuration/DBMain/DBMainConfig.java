package com.ztgeo.pointtopoint.utils.configuration.DBMain;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "com.ztgeo.pointtopoint.mapper.mainMapper", sqlSessionFactoryRef = "sqlSessionFactionMain", sqlSessionTemplateRef = "sqlSessionTemplateMain")
public class DBMainConfig {
    @Bean(name = "dbMain")
    //下面这个注解控制哪个实例优先被注入，我们放在第一个数据源上面
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.dbMain")
    public DataSource dataSourceMain() {
        return DruidDataSourceBuilder.create().build();
    }

    @Cacheable
    @CachePut
    @Bean(name = "sqlSessionFactionMain")
    public SqlSessionFactory sqlSessionFactoryMain(@Qualifier("dbMain") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.ztgeo.pointtopoint.handle.entity");
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/main/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "dbMainTransactionManager")
    public DataSourceTransactionManager dbMainTransactionManager(@Qualifier("dbMain") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplateMain")
    public SqlSessionTemplate sqlSessionTemplateMain(@Qualifier("sqlSessionFactionMain") SqlSessionFactory sqlSessionFactory) throws Exception {
        //使用注解中配置的Factory
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }

    @Bean
    public ServletRegistrationBean druidServlet1() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("loginUsername", "admin");// 用户名
        initParameters.put("loginPassword", "admin");// 密码
        initParameters.put("resetEnable", "false");// 禁用HTML页面上的“Reset All”功能
        initParameters.put("allow", ""); // IP白名单 (没有配置或者为空，则允许所有访问)
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean1() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
