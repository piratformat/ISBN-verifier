package com.piratformat.isbnverifier;

import com.piratformat.isbnverifier.service.IsbnVerifierServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IsbnVerfierServiceImplTest {
    public IsbnVerifierServiceImpl isbnVerifierService = new IsbnVerifierServiceImpl();

    static Stream<Arguments> correctISBN10IntArrayProvider() {
        return Stream.of(
                Arguments.of((String) "9185057819"),
                Arguments.of((String) "0198526636"),
                Arguments.of((String) "1861972717")
        );
    }
    static Stream<Arguments> incorrectISBN10IntArrayProvider() {
        return Stream.of(
                Arguments.of((String) "9185057812"),
                Arguments.of((String) "0198526635"),
                Arguments.of((String) "1861972713")
        );
    }
    static Stream<Arguments> correctISBN10WithXIntArrayProvider() {
        return Stream.of(
                Arguments.of((String) "085647732X"),
                Arguments.of((String) "023538531X"),
                Arguments.of((String) "080597430X")
        );
    }
    static Stream<Arguments> incorrectISBN10WithXIntArrayProvider() {
        return Stream.of(
                Arguments.of((String) "085647733X"),
                Arguments.of((String) "023538532X"),
                Arguments.of((String) "080597431X")
        );
    }
    static Stream<Arguments> incorrectISBN10WithCharsIntArrayProvider() {
        return Stream.of(
                Arguments.of((String) "085es77332"),
                Arguments.of((String) "023wq85323"),
                Arguments.of((String) "080592ds11")
        );
    }
    static Stream<Arguments> correctISBN13IntArrayProvider() {
        return Stream.of(
                Arguments.of((String) "9781566199094"),
                Arguments.of((String) "9783161484100"),
                Arguments.of((String) "9781402894626")
        );
    }
    static Stream<Arguments> incorrectISBN13IntArrayProvider() {
        return Stream.of(
                Arguments.of((String) "9781566199095"),
                Arguments.of((String) "9783161484101"),
                Arguments.of((String) "9781402894627")
        );
    }
    static Stream<Arguments> incorrectISBN13WithCharsIntArrayProvider() {
        return Stream.of(
                Arguments.of((String) "97815hej99095"),
                Arguments.of((String) "9783hello4101"),
                Arguments.of((String) "9781ciao94627")
        );
    }

    @ParameterizedTest
    @MethodSource("correctISBN10IntArrayProvider")
    void verifyIsbn10_WhenValidData_ShouldReturnTrue(String numbers) {
        assertFalse(isbnVerifierService.verifyIsbn13(numbers));
    }

    @ParameterizedTest
    @MethodSource("incorrectISBN10IntArrayProvider")
    void verifyIsbn10_WhenInvalidData_ShouldReturnFalse(String numbers) {
        assertFalse(isbnVerifierService.verifyIsbn13(numbers));
    }

    @ParameterizedTest
    @MethodSource("correctISBN10WithXIntArrayProvider")
    void verifyIsbn10_WhenDataWithXEnding_ShouldReturnTrue(String numbers){
        assertTrue(isbnVerifierService.verifyIsbn10(numbers));
    }

    @ParameterizedTest
    @MethodSource("incorrectISBN10WithXIntArrayProvider")
    void verifyIsbn10_WhenDataWithXEnding_ShouldReturnFalse(String numbers){
        assertFalse(isbnVerifierService.verifyIsbn10(numbers));
    }

    @ParameterizedTest
    @MethodSource("incorrectISBN10WithCharsIntArrayProvider")
    void verifyIsbn10_WhenCharsInString_ShouldReturnFalse(String numbers){
        assertFalse(isbnVerifierService.verifyIsbn10(numbers));
    }

    @ParameterizedTest
    @MethodSource("correctISBN13IntArrayProvider")
    void verifyIsbn13_WhenValidData_ShouldReturnTrue(String numbers) {
        assertTrue(isbnVerifierService.verifyIsbn13(numbers));
    }

    @ParameterizedTest
    @MethodSource("incorrectISBN13IntArrayProvider")
    void verifyIsbn13_WhenInvalidData_ShouldReturnFalse(String numbers) {
        assertFalse(isbnVerifierService.verifyIsbn13(numbers));
    }

    @ParameterizedTest
    @MethodSource("incorrectISBN13WithCharsIntArrayProvider")
    void verifyIsbn13_WhenCharsInString_ShouldReturnFalse(String numbers) {
        assertFalse(isbnVerifierService.verifyIsbn13(numbers));
    }
}
