package entities;

import java.time.LocalDateTime;

/**
 * Flight sınıfı, uçuş bilgilerini tutar.
 */
public class Flight {
    private Location departure;
    private Location arrival;
    private LocalDateTime departureTime;
    private Aircraft aircraft;

    public Flight(Location departure, Location arrival, LocalDateTime departureTime, Aircraft aircraft) {
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.aircraft = aircraft;
    }

    public Location getDeparture() {
        return departure;
    }

    public Location getArrival() {
        return arrival;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    @Override
    public String toString() {
        return departure + " → " + arrival + " | " + departureTime + " | " + aircraft;
    }
}
