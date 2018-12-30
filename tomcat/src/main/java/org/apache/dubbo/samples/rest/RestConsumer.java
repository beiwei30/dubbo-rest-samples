package org.apache.dubbo.samples.rest;

import org.apache.dubbo.samples.rest.api.User;
import org.apache.dubbo.samples.rest.api.UserService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RestConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/rest-consumer.xml");
        context.start();

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(">>> " + userService.getUser(1L));

        User user = new User(2L, "Larry Page");
        System.out.println(">>> " + userService.registerUser(user));
    }
}
