package org.example;
class Request {
    private TravelersCard travelersCard = new TravelersCard();

    public void addTrip(Trip trip) {
        travelersCard.add(trip);
    }

    public TravelersCard getTravelersCard() {
        return travelersCard;
    }
}