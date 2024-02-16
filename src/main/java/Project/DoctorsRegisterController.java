package Project;

import Project.MainApp;
import Project.doctor.Doctor;
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
import java.util.ResourceBundle;

/**
 * The StorageController class controls the interaction with the storage window.
 */
public class DoctorsRegisterController implements Initializable {

    @FXML
    private TableView<Doctor> tableView;

    @FXML
    private TableColumn<Doctor, String> colName;

    @FXML
    private TableColumn<Doctor, String> colSurname;

    @FXML
    private TableColumn<Doctor, String> colSpeciality;

    @FXML
    private TableColumn<Doctor, String> colPhoneNumber;

    @FXML
    private TableColumn<Doctor, String> colEmail;

    @FXML
    private Button exitDoctorsRegisterButton;

    /**
     * Initializes the storage controller.
     *
     * @param arg0 The URL of the FXML file.
     * @param arg1 The ResourceBundle for internationalization.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        colSpeciality.setCellValueFactory(new PropertyValueFactory<>("speciality"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone number"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableView.setItems(MainApp.getDocObservableList());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    /**
     * Exits the storage window and opens the main application.
     *
     * @throws IOException if an I/O exception occurs.
     */
    @FXML
    protected void exitDoctorsRegister() throws IOException {
        Stage stage = (Stage) exitDoctorsRegisterButton.getScene().getWindow();
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
