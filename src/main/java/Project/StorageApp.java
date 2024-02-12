package Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The StorageApp class represents the application for displaying storage contents.
 */
public class StorageApp extends Application {

    /**
     * Starts the application.
     *
     * @param stage The primary stage for the application.
     * @throws IOException if an I/O exception occurs.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StorageWindow.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 300, 450);
        stage.setTitle("Storage Contents");
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