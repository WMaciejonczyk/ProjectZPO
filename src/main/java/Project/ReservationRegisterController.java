package Project;

import Project.doctor.Doctor;
import Project.reservation.Reservation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReservationRegisterController implements Initializable {

    @FXML
    private TableView<Reservation> tableView;

    @FXML
    private TableColumn<Reservation, String> colDoctorID;

    @FXML
    private TableColumn<Reservation, String> colReservationStart;

    @FXML
    private TableColumn<Reservation, String> colReservationEnd;

    @FXML
    private TableColumn<Reservation, String> colEquipmentName;

    @FXML
    private TableColumn<Reservation, String> colEquipmentAmount;

    @FXML
    private TableColumn<Reservation, String> colMaterialName;

    @FXML
    private TableColumn<Reservation, String> colMaterialAmount;

    @FXML
    private TableColumn<Reservation, String> colMedicineName;

    @FXML
    private TableColumn<Reservation, String> colMedicineAmount;

    @FXML
    private Button exitReservationRegister;

    /**
     * Initializes the storage controller.
     *
     * @param arg0 The URL of the FXML file.
     * @param arg1 The ResourceBundle for internationalization.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colDoctorID.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
        colReservationStart.setCellValueFactory(new PropertyValueFactory<>("reservationStart"));
        colReservationEnd.setCellValueFactory(new PropertyValueFactory<>("reservationEnd"));
        colEquipmentName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
        colEquipmentAmount.setCellValueFactory(new PropertyValueFactory<>("equipmentAmount"));
        colMaterialName.setCellValueFactory(new PropertyValueFactory<>("materialName"));
        colMaterialAmount.setCellValueFactory(new PropertyValueFactory<>("materialAmount"));
        colMedicineName.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        colMedicineAmount.setCellValueFactory(new PropertyValueFactory<>("medicineAmount"));
        tableView.setItems(MainApp.getReservationsRegister());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    /**
     * Exits the storage window and opens the main application.
     *
     * @throws IOException if an I/O exception occurs.
     */
    @FXML
    protected void exitReservationRegister() throws IOException {
        Stage stage = (Stage) exitReservationRegister.getScene().getWindow();
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
