package org.calculator;

import java.util.Scanner;

public class ScientificCalculator {

    // The square root of a number
    public static double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot compute square root of a negative number.");
        }
        return Math.sqrt(x);
    }

    // The factorial of a number
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot compute factorial of a negative number.");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Infinity (factorial value too large).");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // The natural logarithm of a number
    public static double naturalLog(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Natural logarithm is undefined for zero or negative numbers.");
        }
        return Math.log(x);
    }

    // Method to compute the power function (base^exponent)
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            // menu
            System.out.println("\n========== Scientific Calculator ==========");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power Function (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid option number.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        // Square root
                        System.out.print("Enter a non-negative number: ");
                        double num = Double.parseDouble(scanner.nextLine());
                        double sqrtResult = squareRoot(num);
                        System.out.println("Square root of " + num + " is: " + sqrtResult);
                        break;
                    case 2:
                        // Factorial
                        System.out.print("Enter a non-negative integer: ");
                        int n = Integer.parseInt(scanner.nextLine());
                        long factResult = factorial(n);
                        System.out.println("Factorial of " + n + " is: " + factResult);
                        break;
                    case 3:
                        // Natural logarithm
                        System.out.print("Enter a positive number: ");
                        double lnInput = Double.parseDouble(scanner.nextLine());
                        double lnResult = naturalLog(lnInput);
                        System.out.println("Natural logarithm of " + lnInput + " is: " + lnResult);
                        break;
                    case 4:
                        // Power function
                        System.out.print("Enter the base: ");
                        double base = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter the exponent: ");
                        double exponent = Double.parseDouble(scanner.nextLine());
                        double powerResult = power(base, exponent);
                        System.out.println(base + " raised to the power " + exponent + " is: " + powerResult);
                        break;
                    case 5:
                        // Exit
                        System.out.println("Exiting calculator. Goodbye!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please try again.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
