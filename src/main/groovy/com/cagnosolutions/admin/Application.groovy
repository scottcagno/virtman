package com.cagnosolutions.admin
import groovy.transform.CompileStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@CompileStatic
@ComponentScan
@EnableAutoConfiguration
class Application extends WebMvcConfigurerAdapter{

    static void main(String... args) {
        SpringApplication.run Application, args
    }

    void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}



