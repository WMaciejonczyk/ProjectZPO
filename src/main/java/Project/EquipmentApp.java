package Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The EquipmentApp class represents the application for adding equipment.
 */
public class EquipmentApp extends Application {

    /**
     * The main entry point for the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Starts the application.
     *
     * @param stage The primary stage for the application.
     * @throws IOException if an I/O exception occurs.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("EquipmentWindow.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 280, 250);
        stage.setTitle("Storage Main Menu");
        stage.setScene(scene);
        stage.show();
    }
}