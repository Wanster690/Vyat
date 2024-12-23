package org.example;

import java.util.List;

class TravelService {
    private Request request;

    public TravelService(Request request) {
        this.request = request;
    }

    public void finalizeRequest() {
        System.out.println("Текущие позиции в карте путешественника:");
        List<Trip> trips = request.getTravelersCard().getTrips();

        for (Trip trip : trips) {
            System.out.println(trip);
        }

        System.out.println("Итоговое количество оформленных туров: " + trips.size());
    }
}
