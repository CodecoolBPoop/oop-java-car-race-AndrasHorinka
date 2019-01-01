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
        boolean raceGoing = true;
        Race race = new Race();
        race.createVehicles();

        for (int i = 0; i < race.getRACE_LENGTH(); i++) {
            race.simulateRace();
        }
        System.out.println("Print results ------------------");
        race.printRaceResults();
    }
}


//THe issue is that each Vehicle are added every time. While I wanted to add only the distance. So the order is not correct