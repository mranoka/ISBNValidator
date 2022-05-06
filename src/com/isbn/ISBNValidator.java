package com.isbn;

public class ISBNValidator {
    private static final int[] isbn10decoderArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static final int[] isbn13decoderArray = {1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1};

    public static String isbn13(String isbnNumber) {
        int isbnStringLength = isbnNumber.length();

        if (isbnStringLength == 10 || isbnStringLength == 13) {
            if (isbnStringLength == 10 && validate10DigitISBN(isbnNumber)) {
                return convertToISBN13(isbnNumber);
            } else if (isbnStringLength == 13 && validate13DigitISBN(isbnNumber)) {
                return "Valid";
            } else {
                return "Invalid";
            }
        } else {
            return "Invalid";
        }
    }

    public static boolean validate10DigitISBN(String isbn10) {
        int sum = 0;
        String[] isbn10StringHolderArray = isbn10.split("");

        for (int i = 0; i < isbn10decoderArray.length; i++) {
            if (isbn10StringHolderArray[i].contains("X")) {
                sum += 10 * isbn10decoderArray[i];
            } else {
                sum += Integer.parseInt(isbn10StringHolderArray[i]) * isbn10decoderArray[i];
            }
        }
        return sum % 11 == 0;
    }

    public static boolean validate13DigitISBN(String isbn13) {
        int sum = 0;
        String[] isbn13StringHolderArray = isbn13.split("");

        for (int i = 0; i < isbn13decoderArray.length; i++) {
            sum += Integer.parseInt(isbn13StringHolderArray[i]) * isbn13decoderArray[i];
        }
        return sum % 10 == 0;
    }

    public static String convertToISBN13(String isbn10) {
        String newISBN13Number = "";
        String tempISBN = "978" + isbn10;
        String isbnWithoutLastNumber = tempISBN.substring(0, tempISBN.length() - 1);

        for (int i = 0; i < 10; i++) {
            if (validate13DigitISBN(isbnWithoutLastNumber + i)) {
                newISBN13Number = isbnWithoutLastNumber + i;
                break;
            }
        }

        return newISBN13Number;
    }
}
