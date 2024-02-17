package Project;


import Project.DoctorsRegister.DoctorsRegister;
import Project.ReservationsRegister.ReservationsRegister;
import Project.doctor.Doctor;
import Project.reservation.Reservation;
import Project.storage.Storage;
import Project.supply.Supply;
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
    private static DoctorsRegister doctorsRegister = new DoctorsRegister();
    private static ObservableList<Doctor> DocObservableList = FXCollections.observableArrayList();
    private static ReservationsRegister reservationsRegister = new ReservationsRegister();
    private static ObservableList<Reservation> resObservableList = FXCollections.observableArrayList();

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

        Scene scene = new Scene(root, 300, 400);
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


    /**
     * Gets the observable list of doctors.
     *
     * @return The observable list of doctors.
     */
    public static ObservableList<Doctor> getDocObservableList() {
        return DocObservableList;
    }

    /**
     * Gets the reservation register instance.
     *
     * @return The reservation register instance.
     */
    public static DoctorsRegister getDoctorsRegister() {return doctorsRegister;}

    public static ReservationsRegister getReservationsRegister() {
        return reservationsRegister;
    }

    public static ObservableList<Reservation> getResObservableList() {
        return resObservableList;
    }
}
