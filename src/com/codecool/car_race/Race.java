package com.codecool.car_race;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Race {
    private final int NUMBER_OF_CARS = 10;
    private final int NUMBER_OF_TRUCKS = 10;
    private final int NUMBER_OF_MOTOS = 10;
    private final int RACE_LENGTH = 40;
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
        boolean isRaining = rand.nextBoolean();
        setTruckBrokenDown(false);

        if (getRound() == RACE_LENGTH) {
            return false;
        }
        if (getRound() <= getRoundWhenTruckBrokeDown() + 1) {
            setTruckBrokenDown(true);
        } else {
            for (Truck truck : trucks) {
                int distance = truck.moveForAnHour(isTruckBrokenDown(), isRaining);
                if (distance == 0) {
                    setTruckBrokenDown(true);
                }
                setOrder(truck);
            }
        }

        for (Motorcycle moto: motos) {
            moto.moveForAnHour(isTruckBrokenDown(), isRaining);
            setOrder(moto);
        }
        setTruckBrokenDown(false);
        for (Car car: cars) {
            car.moveForAnHour(isTruckBrokenDown(), isRaining);
            setOrder(car);
        }


        nextRound();
        return true;
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
        for (int i = 0; i < 3; i++) {
            String name = order.get(i).getName();
            int distance = order.get(i).getTotalDistanceTravelled();
            List<Integer> distancePerRound = order.get(i).getDistancePerRound();
            System.out.println("The " + i + ". vehicle is: " + name + ". | Distance travelled: " + distance);
            for (int r = 4; r < RACE_LENGTH; r = r + 5) {

                System.out.println("Distance took at round: " + (r + 1) + ": " + distancePerRound.get(r-1));
            }


        }
        /* print total distance
        print each vehicle - type - name - distance travelled
        print for first 3 vehicle the positions after each round
        -first green, 2nd yellow, 3rd red
         */
    }


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
        setRoundWhenTruckBrokeDown(getRound());
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
