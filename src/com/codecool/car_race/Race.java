package com.codecool.car_race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Race {
    private final int NUMBER_OF_CARS = 10;
    private final int NUMBER_OF_TRUCKS = 10;
    private final int NUMBER_OF_MOTOS = 10;
    private final int RACE_LENGTH = 10;
    private int round = 1;
    private boolean truckBrokenDown = false;
    private int roundWhenTruckBrokeDown = 0;
    private Random rand = new Random();

    private List<Car> cars = new ArrayList<>();
    private List<Truck> trucks = new ArrayList<>();
    private List<Motorcycle> motos = new ArrayList<>();
    private List<Vehicles> order = new ArrayList<>();

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

    int getRACE_LENGTH() {
        return this.RACE_LENGTH;
    }

    public boolean simulateRace() {
        if (getRound() == RACE_LENGTH) {
            return false;
        } else {
            setTruckBrokenDown(false);
            boolean isRaining = rand.nextBoolean();

            if (getRound() > 1 && getRound() <= getRoundWhenTruckBrokeDown() + 1) {
                setTruckBrokenDown(true);
            } else {
                setTruckBrokenDown(false);
            }
            System.out.println("\n round" + getRound() + ": rain: " + isRaining + " ~ truck: " + truckBrokenDown + "\n");

            System.out.println("********** TRUCKS **********");
            for (Truck truck : trucks) {
                int distance = truck.moveForAnHour(isTruckBrokenDown(), isRaining);
                System.err.println("Truck name: " + truck.getName() + " ~ dist: " + distance);
                if (distance == 0) {
                    setTruckBrokenDown(true);
                }
            }

            System.out.println("********** MOTOS **********");
            for (Motorcycle moto : motos) {
                int distance = moto.moveForAnHour(isTruckBrokenDown(), isRaining);
                System.err.println("Motor: " + moto.getName() + " ~ dist: " + distance);
            }

            System.out.println("********** CARS **********");
            for (Car car : cars) {
                int distance = car.moveForAnHour(isTruckBrokenDown(), isRaining);
                System.err.println("Car: " + car.getName() + " ~ dist: " + distance);
            }

            nextRound();
            return true;
        }
    }

    void printRaceResults() {
        int[] travels = new int[NUMBER_OF_TRUCKS + NUMBER_OF_CARS + NUMBER_OF_MOTOS];

        for (int i = 0; i < NUMBER_OF_TRUCKS; i++) {
            travels[i] = trucks.get(i).getTotalDistanceTravelled();
        }

        for (int i = NUMBER_OF_TRUCKS; i < NUMBER_OF_CARS + NUMBER_OF_TRUCKS; i++) {
            travels[i] = cars.get(i - NUMBER_OF_TRUCKS).getTotalDistanceTravelled();
        }

        for (int i = NUMBER_OF_TRUCKS + NUMBER_OF_CARS; i < NUMBER_OF_CARS + NUMBER_OF_TRUCKS + NUMBER_OF_MOTOS; i++) {
            travels[i] = cars.get(i - NUMBER_OF_TRUCKS - NUMBER_OF_CARS).getTotalDistanceTravelled();
        }

        Arrays.sort(travels);

        for (int i = 0; i < 3; i++) {
            int position_value = travels[i];

            for (Truck truck : trucks) {
                if (truck.getTotalDistanceTravelled() == position_value) {
                    this.order.add(truck);
                }
            }

            for (Car car : cars) {
                if (car.getTotalDistanceTravelled() == position_value) {
                    this.order.add(car);
                }
            }

            for (Motorcycle moto : motos) {
                if (moto.getTotalDistanceTravelled() == position_value) {
                    this.order.add(moto);
                }
            }
        }

        for (Vehicles vehicle : order) {
            System.out.println(vehicle.getName() + " ~ distance: " + vehicle.getTotalDistanceTravelled());
        }
    }


    private void setTruckBrokenDown(boolean truckBrokenDown) {
        this.truckBrokenDown = truckBrokenDown;
        if (truckBrokenDown) {
            setRoundWhenTruckBrokeDown(getRound());
        }
    }

    private boolean isTruckBrokenDown() {
        return this.truckBrokenDown;
    }

    private int getRound() {
        return this.round;
    }

    private void nextRound() {
        this.round += 1;
    }

    private int getRoundWhenTruckBrokeDown() {
        return this.roundWhenTruckBrokeDown;
    }

    private void setRoundWhenTruckBrokeDown(int roundWhenTruckBrokeDown) {
        this.roundWhenTruckBrokeDown = roundWhenTruckBrokeDown;

    }

}
