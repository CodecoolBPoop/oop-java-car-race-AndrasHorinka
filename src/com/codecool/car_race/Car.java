package com.codecool.car_race;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class Car implements Vehicles {

    private static List<String> firstNames = new LinkedList<String>();
    private static List<String> lastNames = new LinkedList<String>();

    int originalSpeed = 0;
    int actualSpeed = 0;
    int totalDistanceTravelled = 0;
    List<Integer> distancePerRound = new ArrayList<>();
    String name = null;


    public Car() {
        //use random to get names
        //call setName
        //set originalSpeed
    }


    @Override
    public void prepareForLap(Race race) {

    }

    @Override
    public void moveForAnHour() {

    }

    @Override
    public void setName() {
        String newName;
        /* call random to pick a nem from firstName and lastName
        concatenate them
         */
        this.name = newName;
    }


    @Override
    public void calculateDistance() {



    }

    @Override
    public void setDistancePerRound() {

    }


    public void adjustRoundSpeed(boolean truckBrokenDown) {
        if (truckBrokenDown) {
            this.actualSpeed = 75;
        } else {
            this.actualSpeed = this.originalSpeed
        }

    }

}

/*
    Car // If there is a broken down Truck on the track, then limit the max speed of cars to 75 km/h.
            normalSpeed // the normal speed of the car. Set to a random number in the constructor between 80-110km/h.

    name // Make a list from the words here: http://www.fantasynamegenerators.com/car-names.php and pick 2 randomly for each instance.

            distanceTraveled // holds the summarized distance traveled in the race.

    prepareForLap(Race race) // setup the actual speed used for the current lap

    moveForAnHour() // The vehicle travels for an hour. It increases the distance traveled. Call this from the Race::simulateRace() only!


Adventure
Augury
Dynamo
Blaze
Basilisk
Buffalo
Storm
Inquiry
Barrage
Twister
Zeal
Paradox
Eagle
Oracle
Viper
Orbit
Aeon
Excursion
Shadow
Expedition

    */