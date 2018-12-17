package com.codecool.car_race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Truck implements Vehicles {
    private Random rand = new Random();
    private static List<String> truckNames = new ArrayList<>();

    private int totalDistanceTravelled = 0;
    private int breakdownTurnsLeft = 0;
    List<Integer> distancePerRound = new ArrayList<>();
    String name = null;

    public Truck() {
        generateName();
    }

    public void generateName() {
        String name = new String();
        while (truckNames.contains(this.name)) {
            name = "Truck" + rand.nextInt(1001);
        }
        Truck.truckNames.add(name);
        this.name  = name;
    }

    private void setBreakdownTurnsLeft(int breakdownTurnsleft) {
        this.breakdownTurnsLeft = breakdownTurnsleft;
    }

    private int getBreakdownTurnsLeft() {
        return breakdownTurnsLeft;
    }

    private boolean isBroken() {
        if (rand.nextInt(100) < 5) {
            return true;
        }
        return false;
    }

    @Override
    public int moveForAnHour(boolean truckBrokenDown, boolean isRaining) {
        if (getBreakdownTurnsLeft() > 0) {
            setBreakdownTurnsLeft(getBreakdownTurnsLeft() - 1);
            return 0;
        } else {
            if (isBroken()) {
                setBreakdownTurnsLeft(2);
                return 0;
            }
        }
        return this.calculateDistance(false);
    }

    @Override
    public int calculateDistance(boolean truckBrokenDown) {
        this.distancePerRound.add(100);
        this.totalDistanceTravelled += 100;
        return 100;
        }


}

/*

    Truck // speed: 100km/h. 5% chance of breaking down for 2 turns.
            // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.

            breakdownTurnsLeft // holds how long its still broken down.

    distanceTraveled // holds the summarized distance traveled in the race.
    prepareForLap(Race race) // setup the actual speed used for the current lap
    moveForAnHour() // The vehicle travels for an hour. It increases the distance traveled. Call this from the Race::simulateRace() only!
     */