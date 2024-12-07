package Recursion;

/*
    Create a function to convert a decimal number to binary         2 | 10 | 0
    !! Divide given number recursively by 2.                        2 | 5  | 1
                                                                    2 | 2  | 0
        10 / 2 = 5  R0  A                                             | 0  | 1
        5  / 2 = 2  R1  |
        2  / 2 = 0  R0  |                                       (This chart helps)

          Find the binary by writing
          the remainders in reverse order

          Binary for 10 is 1010
 */

public class BinaryConverter {

    public String numberBinary(int decimal) {

        if (decimal == 0) {
            return ""; // Empty string because quotient is already 0
        }

        return numberBinary(decimal / 2) + (decimal % 2);
    }

    public static void main(String[] args) {
        BinaryConverter test = new BinaryConverter();
        System.out.println(test.numberBinary(55));
    }

}
