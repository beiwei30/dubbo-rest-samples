package org.apache.dubbo.samples.rest.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public interface UserService {
    @GET
    @Path("{id: \\d+}")
    User getUser(@PathParam("id") Long id);

    @GET
    List<User> getUsers(@Context HttpServletRequest request);

    @POST
    @Path("register")
    Long registerUser(User user);
}
