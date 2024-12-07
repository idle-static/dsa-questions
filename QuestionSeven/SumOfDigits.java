package Recursion;


/*
  Write a function to determine the sum of a positive integer's digits using recursion
  !! f(n) = n % 10 + f(n / 10)

 */

public class SumOfDigits {

    public int sumOfDigits(int positiveInteger) {

        if (positiveInteger < 1) {
            return 0;
        }

        if (positiveInteger <= 99) {
            return sumOfDigits(positiveInteger / 10) + (positiveInteger % 10);
        } else {
            return sumOfDigits(positiveInteger / 10) + (positiveInteger / 10) + (positiveInteger % 10);
        }
    }

    public static void main(String[] args) {
        SumOfDigits test = new SumOfDigits();
        System.out.println(test.sumOfDigits(19));
    }
}
