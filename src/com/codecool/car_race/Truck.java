package com.codecool.car_race;

public class Truck {
}

/*

    Truck // speed: 100km/h. 5% chance of breaking down for 2 turns.
            // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.

            breakdownTurnsLeft // holds how long its still broken down.

    distanceTraveled // holds the summarized distance traveled in the race.
    prepareForLap(Race race) // setup the actual speed used for the current lap
    moveForAnHour() // The vehicle travels for an hour. It increases the distance traveled. Call this from the Race::simulateRace() only!
     */