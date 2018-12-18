package com.codecool.car_race;


public class Main {
    /**
     * Entry point of our program. Creates one race instance and
     * uses that.
     * <p>
     *
     * @param args commandline arguments passed to the program.
     *             It is unused.
     */
    public static void main(String[] args) {
        Weather weather = new Weather();
        Race race = new Race();
        race.createVehicles();

        race.simulateRace(weather.isRaining());
        race.printRaceResults();
    }
}
