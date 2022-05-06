package com.isbn;
import java.util.Scanner;

public class ISBNValidatorRunner {
    public static void main(String[] args) {
        System.out.print("Please enter ISBN Number: ");
        Scanner scanner = new Scanner(System.in);
        String isbnNumber = scanner.next();
        System.out.println("Result: " + ISBNValidator.isbn13(isbnNumber));
    }
}
