package com.demo.service.demoservice.config;

import org.springframework.beans.factory.annotation.Value;

public class TestJavaConfigBean {

    private static volatile TestJavaConfigBean testJavaConfigBean;

    private TestJavaConfigBean(){}

    public static TestJavaConfigBean getInstance() {
        if (testJavaConfigBean == null){
            synchronized(TestJavaConfigBean.class){
                if (testJavaConfigBean == null){
                    testJavaConfigBean = new TestJavaConfigBean();
                }
            }
        }
        return testJavaConfigBean;
    }

    @Value("${timeout:100}")
    private int timeout;

    @Value("${batch:200}")
    private int batch;

    @Value("${jdbc.url:localhost:3306/demo?serverTimezone=UTC&?useUnicode=true&characterEncoding=utf8&useSSL=false}")
    private String jdbcUrl;

    @Value("${jdbc.driverClassName:com.mysql.cj.jdbc.Driver}")
    private String jdbcDriverClassName;

    @Value("${jdbc.username:root}")
    private String jdbcUsername;

    @Value("${jdbc.password:123456}")
    private String jdbcPassword;

    @Value("${myBatisConfigPath:classpath*:mapper/*.xml}")
    private String myBatisConfigPath;

    @Value("${mapperPackagePath:com.demo.service.demoservice.mapper}")
    private String mapperPackagePath;

    @Value("${entityPackagePath:com.demo.api.demoapi.entity}")
    private String entityPackagePath;

    public String getEntityPackagePath() {
        return entityPackagePath;
    }

    public void setEntityPackagePath(String entityPackagePath) {
        this.entityPackagePath = entityPackagePath;
    }

    public String getMyBatisConfigPath() {
        return myBatisConfigPath;
    }

    public void setMyBatisConfigPath(String myBatisConfigPath) {
        this.myBatisConfigPath = myBatisConfigPath;
    }

    public String getMapperPackagePath() {
        return mapperPackagePath;
    }

    public void setMapperPackagePath(String mapperPackagePath) {
        this.mapperPackagePath = mapperPackagePath;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcDriverClassName() {
        return jdbcDriverClassName;
    }

    public void setJdbcDriverClassName(String jdbcDriverClassName) {
        this.jdbcDriverClassName = jdbcDriverClassName;
    }

    public String getJdbcUsername() {
        return jdbcUsername;
    }

    public void setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getBatch() {
        return batch;
    }
}
