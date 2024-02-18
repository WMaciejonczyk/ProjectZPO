package Project.ReservationsRegister;

import Project.adapters.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import Project.reservation.Reservation;

public class ReservationExporter {

    /**
     * Export reservations from the reservation register to a single JSON file.
     *
     * @param reservations The list of reservations to export.
     * @param filePath     The file path of the JSON file.
     */
    public static void exportReservationsToJson(List<Reservation> reservations, String filePath) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Reservation reservation : reservations) {
                gson.toJson(reservation, writer);
                writer.write(System.lineSeparator()); // Add a new line after each reservation
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}