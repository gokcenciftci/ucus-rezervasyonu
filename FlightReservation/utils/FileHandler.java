package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Reservation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * JSON ile dosya işlemlerini yapar.
 */
public class FileHandler {
    private static final String FILE_PATH = "data/reservations.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveReservations(List<Reservation> reservations) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(reservations, writer);
        } catch (IOException e) {
            System.err.println("Dosyaya yazılırken hata oluştu: " + e.getMessage());
        }
    }

    public static List<Reservation> loadReservations() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<Reservation>>(){}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.err.println("Dosya okunurken hata oluştu veya dosya bulunamadı: " + e.getMessage());
            return null;
        }
    }
}
