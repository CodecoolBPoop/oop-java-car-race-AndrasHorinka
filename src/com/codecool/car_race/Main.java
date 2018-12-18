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
        boolean raceGoing = true;
        Race race = new Race();
        race.createVehicles();

        while (raceGoing) raceGoing = race.simulateRace(weather.isRaining());
        race.printRaceResults();
    }
}
