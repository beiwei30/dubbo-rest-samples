package org.apache.dubbo.samples.rest.extensions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

@Priority(Priorities.USER)
public class TraceInterceptor implements ReaderInterceptor, WriterInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(TraceInterceptor.class);

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
        logger.info("reader interceptor is invoked");
        return context.proceed();
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        logger.info("writer interceptor is invoked");
        context.proceed();
    }
}
