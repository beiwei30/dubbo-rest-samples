package org.apache.dubbo.samples.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserService {
    @GET
    List<User> getUsers();

    @GET
    @Path("{id: \\d+}")
    User getUser(@PathParam("id") Long id);

    @POST
    Long registerUser(User user);
}
