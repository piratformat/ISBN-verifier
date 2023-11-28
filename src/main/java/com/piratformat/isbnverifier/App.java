package com.piratformat.isbnverifier;

import com.piratformat.isbnverifier.logging.LoggingFilter;
import com.piratformat.isbnverifier.resource.IsbnVerifier;
import com.piratformat.isbnverifier.resource.IsbnVerifierImpl;
import com.piratformat.isbnverifier.service.IsbnVerifierService;
import com.piratformat.isbnverifier.service.IsbnVerifierServiceImpl;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

/**
 * Main path for the API.
 * See {@link com.piratformat.isbnverifier.resource.IsbnVerifier} for api resources.
 */
@ApplicationPath("/verify")
public class App extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(LoggingFilter.class); //logging
        resources.add(IsbnVerifier.class);
        resources.add(IsbnVerifierImpl.class);
        resources.add(IsbnVerifierService.class);
        resources.add(IsbnVerifierServiceImpl.class);

        return resources;
    }
}
