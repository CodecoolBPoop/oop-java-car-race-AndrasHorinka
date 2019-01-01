package com.codecool.car_race;

import java.util.ArrayList;
import java.util.LinkedList;
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
    private List<Vehicles> order = new LinkedList<>();

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
                setOrder(truck);
            }

            System.out.println("********** MOTOS **********");
            for (Motorcycle moto: motos) {
                int distance = moto.moveForAnHour(isTruckBrokenDown(), isRaining);
                System.err.println("Motor: " + moto.getName() + " ~ dist: " + distance);
                setOrder(moto);
            }

//            setTruckBrokenDown(false);
            System.out.println("********** CARS **********");
            for (Car car: cars) {
                int distance = car.moveForAnHour(isTruckBrokenDown(), isRaining);
                System.err.println("Car: " + car.getName() + " ~ dist: " + distance);
                setOrder(car);
            }


            nextRound();
            return true;
        }
        /*
        INIT
            we start by checking round number --> if roundWhenTruckBrokeDown +1 < round --> this.truckBrokenDown = false
        RACE
            we start by calculating the trucks - to see if any of them are broken down
            we follow by checking the Motos - considering Weather
            we follow by checking the cars --> watch out parallel runs
                for each vehicle calculate the distance
        TRACKING
            Update the order of vehicles
        END
            Return False if no more rounds left
            */

    }

//    private void moveVehicles(List<Vehicles> vehicleList, boolean isRaining) { --->> I cannot use List<Vehicles> for List<Cars>.. which is odd..
//        for (Vehicles vehicle: vehicleList) {
//            int distance = vehicle.moveForAnHour(isTruckBrokenDown(), isRaining);
//            if (distance == 0) {
//                setTruckBrokenDown(true);
//            }
//        }
//    }

    public void printRaceResults() {
        for (Vehicles vehicle: order) {
            System.out.println(vehicle.getName() + ": " + vehicle.getTotalDistanceTravelled());
        }
//        for (int i = 0; i < 3; i++) {
//            String name = order.get(i).getName();
//            int distance = order.get(i).getTotalDistanceTravelled();
//            List<Integer> distancePerRound = order.get(i).getDistancePerRound();
//            System.out.println("The " + i + ". vehicle is: " + name + ". | Distance travelled: " + distance);
//            for (int r = 4; r < RACE_LENGTH; r = r + 5) {
//                System.out.println("Distance took at round: " + (r + 1) + ": " + distancePerRound.get(r-1));
//            }
//        }
    }
        /* print total distance
        print each vehicle - type - name - distance travelled
        print for first 3 vehicle the positions after each round
        -first green, 2nd yellow, 3rd red
         */


    private void setOrder(Vehicles newVehicle) {
        if (this.order.size() == 0) {
            order.add(newVehicle);
            return;
        }
        for (int i = 0; i < order.size(); i++) {
            Vehicles vehicle = order.get(i);
            if (newVehicle.getTotalDistanceTravelled() < vehicle.getTotalDistanceTravelled()) {
                order.add(i, newVehicle);
                return;
            }
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
