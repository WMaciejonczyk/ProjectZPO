package Project;

import Project.MainApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class DeleteDoctorApp extends Application {

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
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("DoctorDeletionWindow.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 200, 130);
        stage.setTitle("Doctor Deletion Menu");
        stage.setScene(scene);
        stage.show();
    }
}