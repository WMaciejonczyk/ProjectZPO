package Project.storage;

import Project.MainApp;
import Project.ReservationsRegister.ReservationExporter;
import Project.reservation.Reservation;
import Project.supply.Supply;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The StorageController class controls the interaction with the storage window.
 */
public class StorageController implements Initializable {

    @FXML
    private TableView<Supply> tableView;

    @FXML
    private TableColumn<Supply, String> colName;

    @FXML
    private TableColumn<Supply, Integer> colAmount;

    @FXML
    private TableColumn<Supply, Double> colCost;

    @FXML
    private TableColumn<Supply, LocalDate> colDate;

    @FXML
    private Button exportStorageButton;

    @FXML
    private Button exitStorageButton;

    /**
     * Initializes the storage controller.
     *
     * @param arg0 The URL of the FXML file.
     * @param arg1 The ResourceBundle for internationalization.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableView.setItems(MainApp.getTvObservableList());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    /**
     * Exits the storage window and opens the main application.
     *
     * @throws IOException if an I/O exception occurs.
     */
    @FXML
    protected void exitStorage() throws IOException {
        Stage stage = (Stage) exitStorageButton.getScene().getWindow();
        stage.close();
        openMainApp(stage);
    }

    /**
     * Exports the storage to a JSON file.
     *
     * @throws IOException if an I/O exception occurs.
     */
    @FXML
    protected void exportStorageButton() throws IOException {
        List<Supply> supplieslist = MainApp.getTvObservableList();
        String exportDirectory = "storage.json"; // Specify your export directory
        StorageExporter.exportStorageToJson(supplieslist, exportDirectory);
        Stage stage = (Stage) exportStorageButton.getScene().getWindow();
        stage.close();
        openMainApp(stage);
    }

    /**
     * Opens the main application.
     *
     * @param stage The stage of the storage window.
     * @throws IOException if an I/O exception occurs.
     */
    private void openMainApp(Stage stage) throws IOException {
        MainApp mainApp = new MainApp();
        mainApp.start(stage);
    }
}
