package services;

import entities.Reservation;
import java.util.List;

/**
 * Rezervasyon servis arayüzü.
 */
public interface IReservationService {
    boolean makeReservation(Reservation reservation);
    List<Reservation> getAllReservations();
}
