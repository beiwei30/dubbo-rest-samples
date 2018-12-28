package org.apache.dubbo.samples.rest.comp;

import org.apache.dubbo.samples.rest.api.User;
import org.apache.dubbo.samples.rest.api.UserService;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class UserServiceComponent implements UserService {
    @Reference
    private UserService userService;


    @Override
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @Override
    public Long registerUser(User user) {
        return userService.registerUser(user);
    }
}
