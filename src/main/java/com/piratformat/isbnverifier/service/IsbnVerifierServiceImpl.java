package com.piratformat.isbnverifier.service;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * A class to verify ISBN10 codes. <br>
 */
public class IsbnVerifierServiceImpl implements IsbnVerifierService{

    @Override
    public boolean verifyIsbn10(String inputIsbn) {

        inputIsbn = changeXsuffix(inputIsbn);
        if (inputIsbn.equals("Incorrect ISBN")) {
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
        return false;
    }

    /**
     * Method to make an int array of the input string, example: <br>
     * inputIsbnString 9185057819 = [9,1,8,5,0,5,7,8,1,9]
     */
    private int[] stringToIntArray(String inputIsbnString) {
        String[] inputIsbnStringArray = inputIsbnString.split("", 10);
        int[] outputIsbnIntArray = new int[inputIsbnStringArray.length];

        for (int i = 0; i < inputIsbnStringArray.length; i++) {
            outputIsbnIntArray[i] = Integer.parseInt(inputIsbnStringArray[i]);
        }

        return outputIsbnIntArray;
    }

    private boolean checkIsNumericString(String inputIsbn) {
        Pattern numberRegex = Pattern.compile("-?\\d+(\\.\\d+)?");
        return numberRegex.matcher(inputIsbn).matches();
    }

    private boolean isbnEndsWithX(String inputIsbn) {
        return inputIsbn.endsWith("X") || inputIsbn.endsWith("x");
    }

    /**
     * Method to change X to 10 if it occurs in the input string.
     */
    private String changeXsuffix(String inputIsbn) {
        if (!checkIsNumericString(inputIsbn)) {
            if (isbnEndsWithX(inputIsbn)) {
                // Replace "X" with "10"
                inputIsbn = inputIsbn.substring(0, inputIsbn.length() - 1) + "10";
                return inputIsbn;
            } else {
                return "Incorrect ISBN";
            }
        }
        return inputIsbn;
    }
}

