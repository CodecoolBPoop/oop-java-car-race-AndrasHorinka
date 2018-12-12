package com.codecool.car_race;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Race {
    private final int NUMBER_OF_CARS = 10;
    private final int NUMBER_OF_TRUCKS = 10;
    private final int NUMBER_OF_MOTOS = 10;
    private final int RACE_LENGTH = 50;
    private int round = 0;
    private boolean truckBrokenDown = false;
    private int roundWhenTruckBrokeDown = 0;

    private List<Car> cars = new ArrayList<>();
    private List<Truck> trucks = new ArrayList<>();
    private List<Motorcycle> motos = new ArrayList<>();
    private List<Vehicles> Order = new LinkedList<>();

    void createVehicles() {
        createCars();
        createTrucks();
        createMotos();

    }
    private void createCars() {
        for (int i = 0; i < NUMBER_OF_CARS; i++) {
            this.cars.add(new Car());
        }
    }
    private void createTrucks() {
        for (int i = 0; i < NUMBER_OF_TRUCKS; i++) {
            this.trucks.add(new Truck());
        }
    }
    private void createMotos() {
        for (int i = 0; i < NUMBER_OF_MOTOS; i++) {
            this.motos.add(new Motorcycle());
        }
    }

    public void simulateRace(Weather weather) {
        /*
        INIT
            we start by checking round number --> if roundWhenTruckBrokeDown +1 < round --> this.truckBrokenDown = false
            we check the Weather
        RACE
            we start by calculating the trucks - to see if any of them are broken down
            we follow by checking the Motos - considering Weather
            we follow by checking the cars --> watch out parallel runs
                for each vehicle calculate the distance
        TRACKING
            Update the order of vehicles
            */

    }

    public void printRaceResults() {
        /* print total distance
        print each vehicle - type - name - distance travelled
        print for first 3 vehicle the positions after each round
        -first green, 2nd yellow, 3rd red
         */
    }

    public void setTruckBrokenDown(boolean truckBrokenDown) {
        this.truckBrokenDown = truckBrokenDown;
        this.roundWhenTruckBrokeDown = this.round;
    }
}
