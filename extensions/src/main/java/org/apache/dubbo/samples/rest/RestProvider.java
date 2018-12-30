package org.apache.dubbo.samples.rest;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

public class RestProvider {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "org.apache.dubbo.samples.rest.impl")
    static class ProviderConfiguration {
        @Bean
        public ProtocolConfig protocolConfig() {
            ProtocolConfig protocolConfig = new ProtocolConfig();
            protocolConfig.setName("rest");
            protocolConfig.setPort(8080);
            protocolConfig.setServer("netty");
            protocolConfig.setExtension("com.alibaba.dubbo.rpc.protocol.rest.support.LoggingFilter," +
                    "org.apache.dubbo.samples.rest.extensions.CustomExceptionMapper," +
                    "org.apache.dubbo.samples.rest.extensions.DynamicTraceBinding," +
                    "org.apache.dubbo.samples.rest.extensions.TraceInterceptor," +
                    "org.apache.dubbo.samples.rest.extensions.TraceFilter," +
                    "org.apache.dubbo.samples.rest.extensions.ClientTraceFilter");
            return protocolConfig;
        }

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
            applicationConfig.setName("rest-provider");
            return applicationConfig;
        }
    }
}
