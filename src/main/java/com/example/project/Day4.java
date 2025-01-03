package com.example.project;

import java.util.Random;

public class Day4 {

    private static String[] reindeer_names = {"Dasher", "Dancer", "Prancer", "Vixen", "Comet", "Cupid", "Donner", "Blitzen"};

    public static class Reindeer {
        private String name;
        private int speed;
        private int runDuration;
        private int restDuration;
        private int distanceTraveled;
        private int currentRunTime;
        private int currentRestTime;
        private boolean isRunning;

        // Constructor
        public Reindeer(String name, int speed, int runDuration, int restDuration) {
            this.name = name;
            this.speed = speed;
            this.runDuration = runDuration;
            this.restDuration = restDuration;
            this.distanceTraveled = 0;
            this.currentRunTime = 0;
            this.currentRestTime = 0;
            this.isRunning = true;
        }

        // Get the name of the reindeer
        public String getName() {
            return name;
        }

        // Get the distance traveled by this reindeer
        public int getDistanceTraveled() {
            return distanceTraveled;
        }

        // Simulate one second of the race
        public void simulateSecond() {
            if (isRunning) {
                distanceTraveled += speed;
                currentRunTime++;
                if (currentRunTime >= runDuration) {
                    isRunning = false;
                    currentRunTime = 0;
                }
            } else {
                currentRestTime++;
                if (currentRestTime >= restDuration) {
                    isRunning = true;
                    currentRestTime = 0;
                }
            }
        }
    }

    public static String simulateRace(int time, Reindeer[] reindeers) {
        for (int t = 0; t < time; t++) {
            for (int i = 0; i < reindeers.length; i++) {
                reindeers[i].simulateSecond();
            }
        }

        // Find the reindeer with the maximum distance traveled
        Reindeer winner = null;
        int maxDistance = 0;
        for (int i = 0; i < reindeers.length; i++) {
            if (reindeers[i].getDistanceTraveled() > maxDistance) {
                maxDistance = reindeers[i].getDistanceTraveled();
                winner = reindeers[i];
            }
        }

        if (winner == null) {
            return "No winner";
        } else {
            return winner.getName();
        }
    }

    public static void main(String[] args) {
        // Create an array of reindeers with random attributes
        Random random = new Random();
        Reindeer[] reindeers = new Reindeer[reindeer_names.length];

        for (int i = 0; i < reindeer_names.length; i++) {
            int speed = random.nextInt(10) + 10; // Random speed between 10 and 20
            int runDuration = random.nextInt(5) + 5; // Random run duration between 5 and 10
            int restDuration = random.nextInt(5) + 5; // Random rest duration between 5 and 10
            reindeers[i] = new Reindeer(reindeer_names[i], speed, runDuration, restDuration);
        }

        // Simulate the race for 10 seconds
        String winner = simulateRace(10, reindeers);
        System.out.println("The winner is: " + winner);
    }
}
