package org.example;
class Trip {
    private int id;
    private String date;
    private String departure;
    private String arrival;

    public Trip(int id, String date, String departure, String arrival) {
        this.id = id;
        this.date = date;
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getDate() {
        return date;
    }

    public String getArrival() {
        return arrival;
    }

    @Override
    public String toString() {
        return "Trip{id=" + id + ", date='" + date + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' + '}';
    }
}