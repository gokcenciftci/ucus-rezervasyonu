import entities.Aircraft;
import entities.Location;
import entities.Flight;
import entities.Reservation;
import services.IReservationService;
import services.ReservationManager;
import utils.FileHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Uçak Bilet Rezervasyon Konsol Uygulaması
 */
public class Main {
    private static List<Aircraft> aircraftList = new ArrayList<>();
    private static List<Location> locationList = new ArrayList<>();
    private static List<Flight> flightList = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();
    private static IReservationService reservationService = new ReservationManager();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();

        boolean running = true;
        while (running) {
            System.out.println("\n--- Uçak Bilet Rezervasyon Sistemi ---");
            System.out.println("1. Uçuşları Listele");
            System.out.println("2. Rezervasyon Yap");
            System.out.println("3. Rezervasyonları Göster");
            System.out.println("4. Rezervasyonu İptal Et");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminiz: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    listFlights();
                    break;
                case "2":
                    makeReservation();
                    break;
                case "3":
                    showReservations();
                    break;
                case "4":
                    cancelReservation();
                    break;
                case "5":
                    saveData();
                    System.out.println("Çıkış yapılıyor...");
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        }
    }

    private static void loadData() {
        // Yeni uçaklar
        aircraftList.add(new Aircraft("Boeing", "737 MAX", "SN12345", 5));
        aircraftList.add(new Aircraft("Airbus", "A320", "SN54321", 3));
        aircraftList.add(new Aircraft("Embraer", "E195", "SN67890", 6));
        aircraftList.add(new Aircraft("Airbus", "A380", "SN11223", 10));

        // Yeni lokasyonlar
        locationList.add(new Location("Türkiye", "İstanbul", "IST", true));
        locationList.add(new Location("Türkiye", "Ankara", "ESB", true));
        locationList.add(new Location("Almanya", "Berlin", "BER", true));
        locationList.add(new Location("Fransa", "Paris", "CDG", true));
        locationList.add(new Location("Amerika", "New York", "JFK", true));

        // Uçuş zamanları
        LocalDateTime time1 = LocalDateTime.of(LocalDate.now(), LocalTime.parse("08:00"));
        LocalDateTime time2 = LocalDateTime.of(LocalDate.now(), LocalTime.parse("12:00"));
        LocalDateTime time3 = LocalDateTime.of(LocalDate.now(), LocalTime.parse("15:00"));
        LocalDateTime time4 = LocalDateTime.of(LocalDate.now(), LocalTime.parse("18:00"));

        // Yeni uçuşlar
        flightList.add(new Flight(locationList.get(0), locationList.get(1), time1, aircraftList.get(0))); // İstanbul -> Ankara
        flightList.add(new Flight(locationList.get(1), locationList.get(2), time2, aircraftList.get(1))); // Ankara -> Berlin
        flightList.add(new Flight(locationList.get(2), locationList.get(3), time3, aircraftList.get(2))); // Berlin -> Paris
        flightList.add(new Flight(locationList.get(3), locationList.get(4), time4, aircraftList.get(3))); // Paris -> New York

        List<Reservation> loadedReservations = FileHandler.loadReservations();
        if (loadedReservations != null) {
            reservations = loadedReservations;
            System.out.println("Rezervasyonlar dosyadan yüklendi.");
        } else {
            System.out.println("Rezervasyon dosyası bulunamadı, yeni dosya oluşturulacak.");
        }
    }

    private static void saveData() {
        FileHandler.saveReservations(reservations);
        System.out.println("Rezervasyonlar dosyaya kaydedildi.");
    }

    private static void listFlights() {
        System.out.println("\nMevcut Uçuşlar:");
        for (int i = 0; i < flightList.size(); i++) {
            Flight f = flightList.get(i);
            System.out.printf("%d) %s -> %s | Saat: %s | Uçak: %s %s | Kapasite: %d\n",
                    i + 1,
                    f.getDeparture().getCity(),
                    f.getArrival().getCity(),
                    f.getDepartureTime(),
                    f.getAircraft().getBrand(),
                    f.getAircraft().getModel(),
                    f.getAircraft().getSeatCapacity());
        }
    }

    private static void makeReservation() {
        listFlights();
        System.out.print("\nRezervasyon yapmak istediğiniz uçuş numarasını seçin: ");
        int flightIndex;
        try {
            flightIndex = Integer.parseInt(scanner.nextLine()) - 1;
            if (flightIndex < 0 || flightIndex >= flightList.size()) {
                System.out.println("Geçersiz uçuş seçimi!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Lütfen geçerli bir sayı girin!");
            return;
        }

        Flight selectedFlight = flightList.get(flightIndex);
        long reservedSeats = reservations.stream()
                .filter(r -> r.getFlight().equals(selectedFlight))
                .count();

        if (reservedSeats >= selectedFlight.getAircraft().getSeatCapacity()) {
            System.out.println("Bu uçuş için yer kalmamıştır.");
            return;
        }

        // Kullanıcı bilgilerini al
        System.out.print("Adınız: ");
        String firstName = scanner.nextLine();

        System.out.print("Soyadınız: ");
        String lastName = scanner.nextLine();

        System.out.print("Yaşınız: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Yaş sayısal olmalıdır.");
            return;
        }

        System.out.print("Telefon Numaranız: ");
        String phoneNumber = scanner.nextLine();

        Reservation newReservation = new Reservation(selectedFlight, firstName, lastName, age, phoneNumber);
        if (reservationService.makeReservation(newReservation)) {
            reservations.add(newReservation);
            System.out.println("Rezervasyonunuz başarıyla oluşturuldu!");
        } else {
            System.out.println("Rezervasyon yapılamadı.");
        }
    }

    private static void showReservations() {
        System.out.println("\nMevcut Rezervasyonlar:");
        if (reservations.isEmpty()) {
            System.out.println("Hiç rezervasyon bulunmamaktadır.");
        } else {
            for (Reservation r : reservations) {
                System.out.printf("- %s %s, Yaş: %d, Telefon: %s, Uçuş: %s -> %s, Saat: %s, Uçak: %s %s\n",
                        r.getFirstName(),
                        r.getLastName(),
                        r.getAge(),
                        r.getPhoneNumber(),
                        r.getFlight().getDeparture().getCity(),
                        r.getFlight().getArrival().getCity(),
                        r.getFlight().getDepartureTime(),
                        r.getFlight().getAircraft().getBrand(),
                        r.getFlight().getAircraft().getModel());
            }
        }
    }

    private static void cancelReservation() {
        System.out.println("\nMevcut Rezervasyonlar:");
        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            System.out.printf("%d) %s %s, Uçuş: %s -> %s, Saat: %s\n", 
                    i + 1, r.getFirstName(), r.getLastName(),
                    r.getFlight().getDeparture().getCity(), 
                    r.getFlight().getArrival().getCity(),
                    r.getFlight().getDepartureTime());
        }

        System.out.print("İptal etmek istediğiniz rezervasyon numarasını girin: ");
        int cancelIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (cancelIndex >= 0 && cancelIndex < reservations.size()) {
            reservations.remove(cancelIndex);
            System.out.println("Rezervasyon iptal edildi.");
        } else {
            System.out.println("Geçersiz rezervasyon numarası.");
        }
    }
}
