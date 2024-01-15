package com.tmp.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableWebMvc
@ComponentScan(
        basePackages = {
                "com.tmp.controller"
        }
)
public class AppConfig {

}
