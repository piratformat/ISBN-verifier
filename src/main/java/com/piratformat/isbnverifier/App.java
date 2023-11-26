package com.piratformat.isbnverifier;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Main path for the API.
 * See {@link com.piratformat.isbnverifier.resource.IsbnVerifier} for api resources.
 */
@ApplicationPath("/verify")
public class App extends Application {
    // Smile! :)
}
