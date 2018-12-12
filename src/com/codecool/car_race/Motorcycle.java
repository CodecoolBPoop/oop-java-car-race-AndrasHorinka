package com.codecool.car_race;

public class Motorcycle {
}

/*
    Motorcycle // speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly). Doesn't care about trucks.
            motorcycleNumber // The number of the instance created. Used for its name.

    name // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
            distanceTraveled // holds the summarized distance traveled in the race.

    prepareForLap(Race race) // setup the actual speed used for the current lap
    moveForAnHour() // The vehicle travels for an hour. It increases the distance traveled. Call this from the Race::simulateRace() only!

    */