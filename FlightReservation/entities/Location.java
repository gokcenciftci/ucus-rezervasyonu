package entities;

/**
 * Location sınıfı, bir yerleşim yerini temsil eder.
 */
public class Location {
    private String country;
    private String city;
    private String airportCode;
    private boolean isActive;

    public Location(String country, String city, String airportCode, boolean isActive) {
        this.country = country;
        this.city = city;
        this.airportCode = airportCode;
        this.isActive = isActive;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return city + " (" + airportCode + "), " + country;
    }
}
