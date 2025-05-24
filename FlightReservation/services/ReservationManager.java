package services;

import entities.Flight;
import entities.Reservation;

import java.util.ArrayList;
import java.util.List;

/**
 * Rezervasyon işlemlerini yönetir.
 */
public class ReservationManager implements IReservationService {

    private List<Reservation> reservations;

    public ReservationManager() {
        this.reservations = new ArrayList<>();
    }

    @Override
    public boolean makeReservation(Reservation reservation) {
        Flight flight = reservation.getFlight();
        long currentReservations = reservations.stream()
                .filter(r -> r.getFlight().equals(flight))
                .count();

        if (currentReservations < flight.getAircraft().getSeatCapacity()) {
            reservations.add(reservation);
            System.out.println("Rezervasyon başarıyla yapıldı.");
            return true;
        } else {
            System.out.println("Rezervasyon başarısız: Uçakta boş koltuk yok.");
            return false;
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservations;
    }
}
