package com.codecool.car_race;

import java.util.ArrayList;
import java.util.List;

public interface Vehicles {
    int totalDistanceTravelled = 0;
    List<Integer> distancePerRound = new ArrayList<>();
    String name = null;

    void generateName();

    String getName();

    List<Integer> getDistancePerRound();

    int moveForAnHour(boolean truckBrokenDown, boolean isRaining);

    int calculateDistance(boolean truckBrokenDown);

    int getTotalDistanceTravelled();

    void increaseTotalDistanceTravelled(int totalDistanceTravelled);

}
