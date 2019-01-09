package org.apache.dubbo.samples.rest.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("api/users")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@OpenAPIDefinition(
        info = @Info(title = "Dubbo REST Demo API",
                version = "0.1",
                description = "A demo API for Dubbo REST support")
)
public interface UserService {
    @GET
    @Operation(summary = "Get all users")
    List<User> getUsers();

    @GET
    @Path("{id: \\d+}")
    @Operation(summary = "Find a user by ID")
    User getUser(@Parameter(description = "User ID") @PathParam("id") Long id);

    @POST
    @Operation(summary = "Register a new user")
    Long registerUser(@Parameter(description = "a user to register") User user);
}
