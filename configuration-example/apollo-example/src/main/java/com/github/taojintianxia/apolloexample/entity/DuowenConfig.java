package com.github.taojintianxia.apolloexample.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nianjun Sun
 * @date 2019/9/5 13:08
 */
@Data
@Configuration
public class DuowenConfig {

    @Value("${test.key:}")
    private String testKey;

    @Value("${test.value:}")
    private String testValue;
}
