package Project;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The MainApp class represents the main application of the project.
 */
public class MainApp extends Application {
    private static ObservableList<Supply> tvObservableList = FXCollections.observableArrayList();
    private static Storage storage = new Storage();

    /**
     * Starts the application.
     *
     * @param stage The primary stage for the application.
     * @throws IOException if an I/O exception occurs.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("MainWindow.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Main Menu");
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

    /**
     * Gets the observable list of supplies.
     *
     * @return The observable list of supplies.
     */
    public static ObservableList<Supply> getTvObservableList() {
        return tvObservableList;
    }

    /**
     * Gets the storage instance.
     *
     * @return The storage instance.
     */
    public static Storage getStorage() {
        return storage;
    }
}