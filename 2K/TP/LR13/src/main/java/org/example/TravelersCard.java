package org.example;

import java.util.ArrayList;
import java.util.List;

class TravelersCard {
    private List<Trip> trips = new ArrayList<>();

    public void add(Trip trip) {
        trips.add(trip);
    }

    public List<Trip> getTrips() {
        return trips;
    }
}