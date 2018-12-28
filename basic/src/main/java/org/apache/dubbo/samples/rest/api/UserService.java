package org.apache.dubbo.samples.rest.api;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("user")
public interface UserService {
    @GET
    @Path("{id: \\d+}")
    @Produces({ContentType.APPLICATION_JSON_UTF_8})
    User getUser(@PathParam("id") Long id);

    @POST
    @Path("register")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({ContentType.APPLICATION_JSON_UTF_8})
    Long registerUser(User user);
}
