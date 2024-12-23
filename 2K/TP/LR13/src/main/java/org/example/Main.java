package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TripService tripService = new TripService();
        tripService.init(); // Инициализация туров

        // Вывод всех доступных туров
        System.out.println("Доступные туры:");
        tripService.printAll();

        // Создание заявки
        Request request = new Request();

        // Добавление нескольких туров в заявку
        tripService.findByDate("2023-10-01").ifPresent(request::addTrip);
        tripService.findByDate("2023-10-05").ifPresent(request::addTrip);
        tripService.findByDate("2023-10-10").ifPresent(request::addTrip);

        // Вывод информации о текущих турах в заявке
        System.out.println("\nТуры в заявке:");
        List<Trip> tripsInRequest = request.getTravelersCard().getTrips();
        for (Trip trip : tripsInRequest) {
            System.out.println(trip);
        }

        // Поиск туров по месту назначения
        String searchArrival = "London";
        List<Trip> foundTrips = tripService.findByPlaceArrival(searchArrival);
        System.out.println("\nТуры с местом назначения '" + searchArrival + "':");
        foundTrips.forEach(System.out::println);

        // Финализация заявки
        TravelService travelService = new TravelService(request);
        travelService.finalizeRequest(); // Финализация заявки

        // Отправка списка туров по почте
        MileService mileService = new MileService();
        mileService.sendEmail(request.getTravelersCard().getTrips()); // Отправка списка туров
    }
}
