package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class TripService {
    private List<Trip> trips = new ArrayList<>();

    // Метод, который будет вызван после инициализации бина
    public void init() {
        trips.add(new Trip(1, "2023-10-01", "Moscow", "Paris"));
        trips.add(new Trip(2, "2023-10-05", "New York", "London"));
        trips.add(new Trip(3, "2023-10-10", "Tokyo", "Seoul"));
        trips.add(new Trip(4, "2023-10-15", "Berlin", "Madrid"));
        trips.add(new Trip(5, "2023-10-20", "Rome", "Athens"));
        trips.add(new Trip(6, "2023-10-25", "Beijing", "Shanghai"));
        trips.add(new Trip(7, "2023-10-30", "Sydney", "Melbourne"));
        trips.add(new Trip(8, "2023-11-01", "Dubai", "Abu Dhabi"));
        trips.add(new Trip(9, "2023-11-05", "Cairo", "Istanbul"));
        trips.add(new Trip(10, "2023-11-10", "Rio de Janeiro", "Sao Paulo"));
    }

    public void printAll() {
        trips.forEach(System.out::println);
    }

    public Optional<Trip> findByDate(String date) {
        return trips.stream().filter(trip -> trip.getDate().equals(date)).findFirst();
    }

    public List<Trip> findByPlaceArrival(String arrival) {
        List<Trip> result = new ArrayList<>();
        for (Trip trip : trips) {
            if (trip.getArrival().equals(arrival)) {
                result.add(trip);
            }
        }
        return result;
    }
}