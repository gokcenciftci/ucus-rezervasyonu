package entities;

/**
 * Aircraft sınıfı, uçak bilgilerini tutar.
 */
public class Aircraft {
    private String brand;
    private String model;
    private String serialNumber;
    private int seatCapacity;

    public Aircraft(String brand, String model, String serialNumber, int seatCapacity) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.seatCapacity = seatCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (Kapasite: " + seatCapacity + ")";
    }
}
