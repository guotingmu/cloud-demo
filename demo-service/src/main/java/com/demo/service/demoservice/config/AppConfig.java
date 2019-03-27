package com.demo.service.demoservice.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
public class AppConfig {
    @Bean
    public TestJavaConfigBean javaConfigBean() {
        return TestJavaConfigBean.getInstance();
    }
}
