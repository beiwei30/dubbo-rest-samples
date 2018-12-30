package org.apache.dubbo.samples.rest.impl;

import org.apache.dubbo.samples.rest.api.User;
import org.apache.dubbo.samples.rest.api.UserService;

import java.util.concurrent.atomic.AtomicLong;

public class UserServiceImpl implements UserService {
    private final AtomicLong id = new AtomicLong();

    public User getUser(Long id) {
        return new User(id, "username-" + id);
    }

    public Long registerUser(User user) {
        return id.incrementAndGet();
    }
}
