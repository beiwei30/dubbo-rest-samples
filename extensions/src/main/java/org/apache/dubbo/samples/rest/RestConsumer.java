package org.apache.dubbo.samples.rest;

import org.apache.dubbo.samples.rest.api.User;
import org.apache.dubbo.samples.rest.api.UserService;
import org.apache.dubbo.samples.rest.comp.UserServiceComponent;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

public class RestConsumer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();

        UserService userService = context.getBean(UserServiceComponent.class);
        System.out.println(">>> " + userService.getUser(1L));

        User user = new User(2L, "Larry Page");
        System.out.println(">>> " + userService.registerUser(user));
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "org.apache.dubbo.samples.rest.comp")
    @ComponentScan({"org.apache.dubbo.samples.rest.comp"})
    static class ConsumerConfiguration {
        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setProtocol("zookeeper");
            registryConfig.setAddress("localhost");
            registryConfig.setPort(2181);
            return registryConfig;
        }

        @Bean
        public ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("rest-consumer");
            return applicationConfig;
        }
    }
}
