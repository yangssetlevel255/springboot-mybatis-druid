package com.dhu.love;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class yangzyProviderRunner extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(yangzyProviderRunner.class,args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(yangzyProviderRunner.class);
    }

}
