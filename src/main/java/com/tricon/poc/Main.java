package com.tricon.poc;

import java.util.Scanner;

public class Main {

    public static int add(String numbers) {
        // Return 0 for empty input
        if (numbers.isEmpty()) {
            return 0;
        }

        // Handle custom delimiters
        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            String delimiter = parts[0].substring(2);
            numbers = parts[1].replace("\n", delimiter);
        } else {
            numbers = numbers.replace("\n", ",");
        }

        String[] numArray = numbers.split(",");
        boolean negativeNumbers = false;
        int sum = 0;

        for (String numStr : numArray) {
            try {
                int number = Integer.parseInt(numStr.trim());
                // Check for negative numbers
                if (number < 0) {
                    negativeNumbers = true;
                } else if (number <= 1000) {
                    sum += number; // Add valid numbers
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + numStr);
            }
        }

        // Throw exception for negative numbers
        if (negativeNumbers) {
            throw new IllegalArgumentException("Negatives not allowed in input.");
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputBuilder = new StringBuilder();
        String line;

        System.out.println("Enter numbers (type 'exit' to finish):");
        while (!(line = scanner.nextLine()).equalsIgnoreCase("exit")) {
            inputBuilder.append(line).append("\n");
        }

        String input = inputBuilder.toString().trim();
        try {
            int result = add(input);
            System.out.println("Sum: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
