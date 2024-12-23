package org.example;

import java.util.List;

class MileService {
    public void sendEmail(List<Trip> trips) {
        System.out.println("Отправка списка туров по почте:");
        for (Trip trip : trips) {
            System.out.println(trip);
        }
    }
}
