package entities;

/**
 * Reservation sınıfı, rezervasyon bilgilerini tutar.
 */
public class Reservation {
    private Flight flight;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    public Reservation(Flight flight, String firstName, String lastName, int age, String phoneNumber) {
        this.flight = flight;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Yaş: " + age + ", Telefon: " + phoneNumber + ", Uçuş: " + flight;
    }
}
