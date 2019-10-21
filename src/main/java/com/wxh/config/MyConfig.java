package com.wxh.config;

import com.wxh.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration：指明当前类是一个配置类，就是替代之前的Spring配置文件
 */
@Configuration
public class MyConfig {
    /**
     * 将方法的返回值添加到容器中，容器中
     * @return
     */
    @Bean
    public TestService testService(){
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new TestService();
    }

}
