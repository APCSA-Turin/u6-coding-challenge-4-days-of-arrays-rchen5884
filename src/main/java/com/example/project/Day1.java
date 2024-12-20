package com.example.project;


public class Day1 {
    private static final String[] ELF_NAMES = {"Glitter", "Chocolate", "Tiny", "Snowflake", "Frosty"};

    public static String generateElfName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        int randomIndex = (int) (Math.random() * ELF_NAMES.length);
        return ELF_NAMES[randomIndex] + " " + name.trim();
    }

    
}