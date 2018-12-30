package org.apache.dubbo.samples.rest.extensions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class CustomExceptionMapper implements ExceptionMapper<NotFoundException> {
    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionMapper.class);

    @Override
    public Response toResponse(NotFoundException exception) {
        logger.info("custom exception mapper: " + exception);
        return Response.status(Response.Status.NOT_FOUND).entity("requested resource not found").type("text/plain").build();
    }
}
