package Project;

import Project.MainApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The AddDoctorApp class represents the application for adding doctors.
 */
public class AddDoctorApp extends Application {

    /**
     * Starts the application.
     *
     * @param stage The primary stage for the application.
     * @throws IOException if an I/O exception occurs.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("AddDoctorWindow.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 300, 350);
        stage.setTitle("Doctor Adding Menu");
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