package com.example.dorm_management;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class DormManagementApplication {
    private static boolean initialized = false;
    public static void main(String[] args) {
        init();
        SpringApplication.run(DormManagementApplication.class, args);
    }

    public static void init(){
        if(initialized) return;
        initialized = true;
        BasicConfigurator.configure();
        PropertyConfigurator.configure("config/log4j.properties");
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
