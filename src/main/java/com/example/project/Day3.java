package com.example.project;

public class Day3 {
    public static String[][] generateSnowflake(int size) { // you will be tested on this method
        // Ensure the size is odd
        if (size % 2 == 0) {
            throw new IllegalArgumentException("Size must be an odd number.");
        }

        // Initialize the 2D array with spaces
        String[][] grid = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = " ";
            }
        }

        int center = size / 2; // Center of the grid

        // Draw the snowflake:
        for (int i = 0; i < size; i++) {
            grid[i][center] = "*";          // Vertical line
            grid[center][i] = "*";          // Horizontal line
            grid[i][i] = "*";               // Top-left to bottom-right diagonal
            grid[i][size - 1 - i] = "*";    // Top-right to bottom-left diagonal
        }

        return grid;
    }

    // Prints the snowflake - useful for debugging (you will not be tested on this method)
    public static void printSnowflake(String[][] snowflake) {
        for (String[] row : snowflake) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    // Test for the snowflake generation
    public static void main(String[] args) {
        int size = 5; // Example: size of the snowflake
        String[][] snowflake = generateSnowflake(size);

        // Print the snowflake for debugging
        printSnowflake(snowflake);
    }
}
