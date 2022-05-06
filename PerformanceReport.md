## Worst Case Space complexity for ISBN Validator
The time complexity of all the operations involved in the ISBN validator is fixed. This is due to the fact that none of the operations will increase significantly even with the most complex input (which would require the most number of operations).

The most complex input (a 10-digit ISBN number with an 'X' appended to it) would require a fixed number of operations and therefore, using the *Big-O notation*, the worst-case space complexity would be represented by O(1).

To illustrate, I will determine the space complexity for the function that validates an ISBN string:

`    public static String isbn13(String isbnNumber) { 
        int isbnStringLength = isbnNumber.length(); // O(1): assignment operations have fixed complexity

        if (isbnStringLength == 10 || isbnStringLength == 13) {
            if (isbnStringLength == 10 && validate10DigitISBN(isbnNumber)) { // O(1): validate10DigitISBN will run  a fixed number of operations of fixed complexity to validate the input.
                return convertToISBN13(isbnNumber); // O(1): the complexity of operations here will also be fixed
            } else if (isbnStringLength == 13 && validate13DigitISBN(isbnNumber)) {
                return "Valid";
            } else {
                return "Invalid";
            }
        } else {
            return "Invalid";
        }
    }`

    
    
**Summing up the notations for all the operations will yield a complexity of O(1);**