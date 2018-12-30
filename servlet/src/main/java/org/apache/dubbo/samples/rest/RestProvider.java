package org.apache.dubbo.samples.rest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class RestProvider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/rest-provider.xml");
        context.start();
        System.in.read();
    }
}
