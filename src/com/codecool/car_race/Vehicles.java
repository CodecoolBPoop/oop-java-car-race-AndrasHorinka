package com.codecool.car_race;

import java.util.ArrayList;
import java.util.List;

public interface Vehicles {
    int originalSpeed = 0;
    int actualSpeed = 0;
    int totalDistanceTravelled = 0;
    List<Integer> distancePerRound = new ArrayList<>();
    String name = null;


    void prepareForLap(Race race);

    void moveForAnHour();

    void setName();
            /* call random to pick a nem from firstName and lastName
        concatenate them
         */

    void calculateDistance();

    void setDistancePerRound();





}
