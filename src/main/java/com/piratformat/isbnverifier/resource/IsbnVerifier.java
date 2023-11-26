package com.piratformat.isbnverifier.resource;

import jakarta.ws.rs.core.Response;

public interface IsbnVerifier {
    /**
     * Endpoint to see if the API is up and running, created for future probes in container environments. <br>
     * @return 204 NO CONTENT <br>
     */
    Response ping();

    /**
     * Endpoint to verify an ISBN (international Standard Book Number) that was established before 2007. <br>
     * <b>The ISBN contains 10 numbers</b>: <br>
     * First 2 numbers = Group<br>
     * Next 4 numbers = Publisher<br>
     * Next 3 numbers = Title<br>
     * Last number = Check digit<br>
     * @param isbn10 string with 10 digits.
     * @return <b>HTTP 200</b> if ISBN is valid.
     */
    Response verifyIsbn10(String isbn10);


    /**
     * Endpoint to verify an ISBN13 (international Standard Book Number) that was established after 2007. <br>
     * <b>The ISBN13 contains 13 numbers</b>: <br>
     * First 2 numbers = Group<br>
     * Next 4 numbers = Publisher<br>
     * Next 3 numbers = Title<br>
     * Last number = Check digit<br>
     * @param isbn13 string with 10 digits.
     * @return <b>HTTP 200</b> if ISBN is valid.
     */
    Response verifyIsbn13(String isbn13);
}
