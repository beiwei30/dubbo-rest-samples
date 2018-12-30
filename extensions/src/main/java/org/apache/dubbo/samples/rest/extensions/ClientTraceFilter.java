package org.apache.dubbo.samples.rest.extensions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.io.IOException;

public class ClientTraceFilter implements ClientRequestFilter, ClientResponseFilter {
    private static final Logger logger = LoggerFactory.getLogger(ClientTraceFilter.class);

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        logger.info("client request filter invoked: " + requestContext.getUri());
    }

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        logger.info("client response filter invoked: " + responseContext.getStatus());
    }
}
