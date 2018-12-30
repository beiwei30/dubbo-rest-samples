package org.apache.dubbo.samples.rest.impl;

import org.apache.dubbo.samples.rest.api.User;
import org.apache.dubbo.samples.rest.api.UserService;

import com.alibaba.dubbo.rpc.RpcContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class UserServiceImpl implements UserService {
    private final AtomicLong id = new AtomicLong();

    @Override
    public User getUser(Long id) {
        System.out.println(">>> Client address from rpc context: " + RpcContext.getContext().getRequest(
                HttpServletRequest.class).getRemoteAddr());
        return new User(id, "username " + id);
    }

    @Override
    public List<User> getUsers(HttpServletRequest request) {
        System.out.println(">>> Client address from http servlet request: " + request.getRemoteAddr());
        return Arrays.asList(new User(1L, "User1"), new User(2L, "User2"));
    }


    public Long registerUser(User user) {
        return id.incrementAndGet();
    }
}
