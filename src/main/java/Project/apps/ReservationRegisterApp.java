package Project.apps;

import Project.MainApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The ReservationRegisterApp class represents the application for displaying reservation register contents.
 */
public class ReservationRegisterApp extends Application {

    /**
     * Starts the application.
     *
     * @param stage The primary stage for the application.
     * @throws IOException if an I/O exception occurs.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("ReservationRegisterWindow.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 450);
        stage.setTitle("Reservation Register Contents");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main entry point for the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}