package com.demo.service.demoservice.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableApolloConfig
@MapperScan(basePackages = "com.demo.service.demoservice.mapper", sqlSessionTemplateRef  = "mybatisMasterSqlSessionTemplate")
public class MybatisDataSourceConfig {

    @Value("${jdbc.url:'jdbc:mysql:///demo?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC'}")
    private String jdbcUrl;

    @Value("${jdbc.driverClassName:'com.mysql.cj.jdbc.Driver'}")
    private String jdbcDriverClassName;

    @Value("${jdbc.username:'root'}")
    private String jdbcUsername;

    @Value("${jdbc.password:'123456'}")
    private String jdbcPassword;

    @Value("${myBatisConfigPath:'classpath*:mapper/*.xml'}")
    private String myBatisConfigPath;

    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("mybatisMasterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 数据库配置
     * @return
     */
    @Bean(name = "mybatisMasterDataSource")
    @ConfigurationProperties(prefix = "datasource")
    public DataSource mybatisMasterDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //数据库驱动
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        //数据库地址
        dataSource.setJdbcUrl(jdbcUrl);
        //用户名
        dataSource.setUser(jdbcUsername);
        //密码
        dataSource.setPassword(jdbcPassword);
        // 关闭连接后不自动提交
        dataSource.setAutoCommitOnClose(false);
        // 配置c3p0连接池的私有属性
        // 连接池最大线程数
        dataSource.setMaxPoolSize(30);
        // 连接池最小线程数
        dataSource.setMinPoolSize(10);
        // 初始化连接数
        dataSource.setInitialPoolSize(10);
        // 连接超时时间
        dataSource.setCheckoutTimeout(10000);
        // 连接失败重试次数
        dataSource.setAcquireRetryAttempts(2);
        return dataSource;
    }

    @Bean(name = "mybatisMasterSqlSessionFactory")
    public SqlSessionFactory mybatisMasterSqlSessionFactory(@Qualifier("mybatisMasterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(myBatisConfigPath));
        return bean.getObject();
    }

    @Bean(name = "mybatisMasterTransactionManager")
    public DataSourceTransactionManager mybatisMasterTransactionManager(@Qualifier("mybatisMasterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mybatisMasterSqlSessionTemplate")
    public SqlSessionTemplate mybatisMasterSqlSessionTemplate(@Qualifier("mybatisMasterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
