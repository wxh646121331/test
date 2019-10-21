package com.wxh.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件的配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties(prefix = "person") 告诉SpringBoot将本类的所有属性和配置文件中相关的配置进行绑定
 * 只有这个组件是容器中的组件，才能用容器提供的@ConfigurationProperties功能
 */

@Component
@ConfigurationProperties(prefix = "person")
//@PropertySource(value={"classpath:person.yml"})
@Getter
@Setter
@ToString
//@Validated
public class Person {
    /**
     * <bean class="Persion"
     */
//    @Value("${person.name}"
    @Email
    private String name;
//    @Value("#{2*9}")
    private Integer age;
//    @Value("true")
    private boolean isBoss;
    private Date birthDay;
    private Map<String, Object> map;
    private List<String> list;
    private Dog dog;


}
