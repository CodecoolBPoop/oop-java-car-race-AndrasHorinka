package com.codecool.car_race;

import java.util.ArrayList;
import java.util.List;

public interface Vehicles {
    int originalSpeed = 0;
    int actualSpeed = 0;
    int totalDistanceTravelled = 0;
    List<Integer> distancePerRound = new ArrayList<>();
    String name = null;


    void moveForAnHour(boolean truckBrokenDown);

    void calculateDistance(boolean truckBrokenDown);

}
