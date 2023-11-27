package com.piratformat.isbnverifier.resource;

import com.piratformat.isbnverifier.service.IsbnVerifierServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("")
public class IsbnVerifierImpl implements IsbnVerifier{
    IsbnVerifierServiceImpl isbnVerifierServiceImpl = new IsbnVerifierServiceImpl();

    /**
     * Endpoint to see if the API is up and running, created for future probes in container environments. <br>
     * @return 204 NO CONTENT <br>
     */
    @Override
    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public Response ping() {
        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }


    /**
     * @param isbn10 string with 10 digits.
     * @return HTTP 200 if the ISBN10 number is correct. <br>
     * More info in interface class {@link IsbnVerifier}.
     */
    @Override
    @GET
    @Path("/isbn10/{isbn10}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyIsbn10(@PathParam("isbn10") String isbn10) {
        if(isbnVerifierServiceImpl.verifyIsbn10(isbn10)) {
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.OK).entity("Not a correct ISBN10 number.").build();
    }


    /**
     * @param isbn13 string with 13 digits.
     * @return HTTP 200 if the ISBN13 number is correct.
     */
    @Override
    @GET
    @Path("/isbn13/{isbn13}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response verifyIsbn13(@PathParam("isbn13") String isbn13) {
        if(isbnVerifierServiceImpl.verifyIsbn13(isbn13)) {
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.OK).entity("Not a correct ISBN13 number.").build();
    }
}




