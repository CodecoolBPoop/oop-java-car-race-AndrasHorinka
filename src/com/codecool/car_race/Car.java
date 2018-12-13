package com.codecool.car_race;

import java.util.*;

public class Car implements Vehicles {

    private Random rand = new Random();
    private static List<String> names = new LinkedList<String>(Arrays.asList("Adventure", "Aeon", "Augury", "Barrage",
            "Basilisk", "Blaze", "Blend", "Buffalo", "Celestial", "Crusader",
            "Dynamo", "Eagle", "Eternity", "Excursion", "Expedition", "Ferocity", "Formula", "Gallop", "Hollo",
            "Inception", "Inquiry", "Jazz", "Magic", "Moonlight", "Morale", "Olympian", "Oracle", "Orbit", "Paradox",
            "Parallel", "Passion", "Prodigy", "Prospect", "Radiance", "Ranger", "Reach", "Sanctuary", "Shadow",
            "Sliver", "Sprite", "Starlight", "Storm", "Supremacy", "Tigress", "Tracer", "Twister", "Umbra",
            "Universe", "Vanish", "Vertex", "Vigor", "Viper", "Virtue", "Vortex", "Wish", "Zeal"));


    int originalSpeed;
    int actualSpeed;
    int totalDistanceTravelled;
    List<Integer> distancePerRound = new ArrayList<>();
    String name = null;


    public Car() {
        setName();
        setOriginalSpeed();
        this.totalDistanceTravelled = 0;
    }


    @Override
    public void moveForAnHour(boolean truckBrokenDown) {
        this.calculateDistance(truckBrokenDown);

    }

    @Override
    public void calculateDistance(boolean truckBrokenDown) {
        if (truckBrokenDown) {
            this.distancePerRound.add(75);
            this.actualSpeed = 75;
        } else {
            this.distancePerRound.add(this.originalSpeed);
            this.totalDistanceTravelled += originalSpeed;
        }
    }



    private void setName() {
        String newName = "";
        for (int i = 0; i < 2; i++) {
            int nameIndex = rand.nextInt(names.size());
            newName = newName + names.get(nameIndex);
            names.remove(nameIndex);
        }
        this.name = newName;
    }

    private void setOriginalSpeed() {
        this.originalSpeed = rand.nextInt(31) + 80;
    }

}

/*
    Car // If there is a broken down Truck on the track, then limit the max speed of cars to 75 km/h.
            normalSpeed // the normal speed of the car. Set to a random number in the constructor between 80-110km/h.

    name // Make a list from the words here: http://www.fantasynamegenerators.com/car-names.php and pick 2 randomly for each instance.

            distanceTraveled // holds the summarized distance traveled in the race.

    prepareForLap(Race race) // setup the actual speed used for the current lap

    moveForAnHour() // The vehicle travels for an hour. It increases the distance traveled. Call this from the Race::simulateRace() only!
    */