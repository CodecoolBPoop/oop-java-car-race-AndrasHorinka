package com.codecool.car_race;

import java.util.ArrayList;
import java.util.List;

public interface Vehicles {
    int totalDistanceTravelled = 0;
    List<Integer> distancePerRound = new ArrayList<>();
    String name = null;

    public void generateName();

    public int moveForAnHour(boolean truckBrokenDown, boolean isRaining);

    public int calculateDistance(boolean truckBrokenDown);

}
