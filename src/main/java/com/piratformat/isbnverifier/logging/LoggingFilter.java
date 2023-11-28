package com.piratformat.isbnverifier.logging;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Provider
public class LoggingFilter implements ContainerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

    // Injected interface, so we can pick up request URI before it hits the resource interface.
    @Context
    UriInfo uriInfo;

    @Override
    public void filter(ContainerRequestContext requestContext){
       LOGGER.info("{} - {}{}",
               requestContext.getMethod(),
               requestContext.getUriInfo().getBaseUri(),
               requestContext.getUriInfo().getPath());
    }
}
