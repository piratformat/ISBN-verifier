package com.piratformat.isbnverifier.service;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * A class to verify ISBN10 & ISBN13 codes. <br>
 */
public class IsbnVerifierServiceImpl implements IsbnVerifierService{

    private static final String INCORRECT_ISBN = "Incorrect ISBN";  // Compliant

    @Override
    public boolean verifyIsbn10(String inputIsbn) {

        inputIsbn = checkForCharsInString(inputIsbn);
        if (inputIsbn.equals(INCORRECT_ISBN)) {
            return false;
        }

        int[] isbnArray = stringToIntArray(inputIsbn);

        if(isbnArray.length != 10) {
            return false;
        }

        int[] calculatedIsbn = new int[10];
        int x = 0;
        for(int i = 10; i >= 1; i--) {
            calculatedIsbn[x] = isbnArray[isbnArray.length-i] * i;
            x++;
        }

        return Arrays.stream(calculatedIsbn).sum() % 11 == 0;
    }

    @Override
    public boolean verifyIsbn13(String inputIsbn) {

        inputIsbn = checkForCharsInString(inputIsbn);
        if (inputIsbn.equals(INCORRECT_ISBN)) {
            return false;
        }

        int[] isbnArray = stringToIntArray(inputIsbn);

        if(isbnArray.length != 13) {
            return false;
        }

        for (int i = 0; i < isbnArray.length; i++) {
            if(i % 2 != 0) {
                isbnArray[i] = isbnArray[i] * 3;
            }
        }

        return Arrays.stream(isbnArray).sum() % 10 == 0;
    }

    /**
     * Method to make an int array of the input string, example: <br>
     * inputIsbnString 9185057819 = [9,1,8,5,0,5,7,8,1,9]
     */
    private int[] stringToIntArray(String inputIsbnString) {

        String[] inputIsbnStringArray;
        int[] outputIsbnIntArray;

        if (inputIsbnString.length() == 10 || inputIsbnString.length() == 11){
            inputIsbnStringArray = inputIsbnString.split("", 10);
            outputIsbnIntArray = new int[inputIsbnStringArray.length];
        } else if (inputIsbnString.length() == 13) {
            inputIsbnStringArray = inputIsbnString.split("", 13);
            outputIsbnIntArray = new int[inputIsbnStringArray.length];
        } else {
            return new int[0];
        }

        for (int i = 0; i < inputIsbnStringArray.length; i++) {
            outputIsbnIntArray[i] = Integer.parseInt(inputIsbnStringArray[i]);
        }

        return outputIsbnIntArray;
    }

    private String checkForCharsInString(String inputIsbn) {
        if (!checkIsNumericString(inputIsbn)) {
            return changeXsuffix(inputIsbn);
        }
        return inputIsbn;
    }

    private boolean checkIsNumericString(String inputIsbn) {
        Pattern numberRegex = Pattern.compile("-?\\d+(\\.\\d+)?");
        return numberRegex.matcher(inputIsbn).matches();
    }

    private boolean isbnEndsWithX(String inputIsbn) {
        return inputIsbn.endsWith("X") || inputIsbn.endsWith("x");
    }

    private String changeXsuffix(String inputIsbn) {
        if (isbnEndsWithX(inputIsbn)) {
            // Replace "X" with "10"
            inputIsbn = inputIsbn.substring(0, inputIsbn.length() - 1) + "10";
            return inputIsbn;
        } else {
            return INCORRECT_ISBN;
        }
    }
}

