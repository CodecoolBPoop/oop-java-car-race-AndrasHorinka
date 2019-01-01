package com.codecool.car_race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Motorcycle implements Vehicles {
    private int originalSpeed = 100;
    private static List<String> motoNames = new ArrayList<>();

    private Random rand = new Random();
    private int totalDistanceTravelled = 0;
    private List<Integer> distancePerRound = new ArrayList<>();
    private String name = null;


    public Motorcycle() {
        generateName();
    }


    @Override
    public void generateName() {
        int motoNr = Motorcycle.motoNames.size();
        this.name = "Moto " + Integer.toString(motoNr + 1);
        Motorcycle.motoNames.add(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Integer> getDistancePerRound() {
        return this.distancePerRound;
    }

    @Override
    public int moveForAnHour(boolean truckBrokenDown, boolean isRaining) {
        Integer actualSpeed;
        if (isRaining) {
            actualSpeed = getReducedSpeed();
        } else {
            actualSpeed = getOriginalSpeed();
        }

        increaseTotalDistanceTravelled(actualSpeed);
        setDistancePerRound(actualSpeed);
        return actualSpeed;
    }

    @Override
    public int calculateDistance(boolean truckBrokenDown) {
        return 0;
    }


    private int getOriginalSpeed() {
        return originalSpeed;
    }

    private int getReducedSpeed() {
        return originalSpeed - (rand.nextInt(46) + 5);
    }


    @Override
    public int getTotalDistanceTravelled() {
        return this.totalDistanceTravelled;
    }

    @Override
    public void increaseTotalDistanceTravelled(int totalDistanceTravelled) {
        this.totalDistanceTravelled += totalDistanceTravelled;
    }

    private void setDistancePerRound(int distanceTravelled) {
        this.distancePerRound.add(distanceTravelled);
    }
}

/*
    Motorcycle // speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly). Doesn't care about trucks.
            motorcycleNumber // The number of the instance created. Used for its name.

    name // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
            distanceTraveled // holds the summarized distance traveled in the race.

    prepareForLap(Race race) // setup the actual speed used for the current lap
    moveForAnHour() // The vehicle travels for an hour. It increases the distance traveled. Call this from the Race::simulateRace() only!

    */