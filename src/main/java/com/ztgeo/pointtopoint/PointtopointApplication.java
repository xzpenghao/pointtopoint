package com.ztgeo.pointtopoint;

        import com.spring4all.swagger.EnableSwagger2Doc;
        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.jdbc.datasource.DataSourceTransactionManager;
        import org.springframework.scheduling.annotation.EnableScheduling;
        import org.springframework.transaction.PlatformTransactionManager;
        import org.springframework.transaction.annotation.EnableTransactionManagement;

        import javax.sql.DataSource;

//将spring boot自带的DataSourceAutoConfiguration禁掉，防止自动配置数据源

@SpringBootApplication
@EnableSwagger2Doc
@EnableScheduling
public class PointtopointApplication {
    public static void main(String[] args) {
        SpringApplication.run(PointtopointApplication.class, args);
    }
}

