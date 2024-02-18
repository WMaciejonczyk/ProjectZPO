package Project.storage;

import Project.adapters.LocalDateAdapter;
import Project.supply.Supply;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;



public class StorageExporter {

    /**
     * Export supply from the storage to a single JSON file.
     *
     * @param supplies The list of supplies to export.
     * @param filePath     The file path of the JSON file.
     */
    public static void exportStorageToJson(List<Supply> supplies, String filePath) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Supply supply : supplies) {
                gson.toJson(supply, writer);
                writer.write(System.lineSeparator()); // Add a new line after each reservation
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}