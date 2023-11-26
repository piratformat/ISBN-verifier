package com.piratformat.isbnverifier.service;

public interface IsbnVerifierService {
    boolean verifyIsbn10(String inputIsbn);
    boolean verifyIsbn13(String inputIsbn);
}
