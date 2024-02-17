package Project;

import Project.exceptions.InvalidInputException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import Project.doctor.Doctor;
import javafx.scene.control.ComboBox;

/**
 * The AddDoctorController class controls the interaction with the doctor addition window.
 */
public class AddDoctorController {

    @FXML
    TextField textDoctorName;

    @FXML
    TextField textDoctorSurname;

    @FXML
    private ComboBox<Doctor.Speciality> comboDoctorSpeciality;

    @FXML
    TextField textEmail;

    @FXML
    TextField textPhoneNumber;

    @FXML
    Button submitDoctor;

    /**
     * Adds the Doctor to DoctorsRegister when the submit button is clicked.
     *
     * @param event The action event triggered by the submit button.
     * @throws IOException if an I/O exception occurs.
     * @throws InvalidInputException if any text field is empty.
     */
    @FXML
    protected void addDoctorToDoctorsRegister(ActionEvent event) throws IOException {
        if (textDoctorName.getText().isEmpty() || textDoctorSurname.getText().isEmpty() || textEmail.getText().isEmpty()
                || textPhoneNumber.getText().isEmpty()) {
            throw new InvalidInputException("Fields cannot be empty .");
        } else {
            String name = textDoctorName.getText();
            String surname = textDoctorSurname.getText();
            Doctor.Speciality speciality = comboDoctorSpeciality.getValue();
            String email = textEmail.getText();
            String phone = textPhoneNumber.getText();

            Doctor doc = new Doctor(name, surname, speciality, phone, email);
            MainApp.getDoctorsRegister().addSpecialist(doc);
            MainApp.getDocObservableList().add(doc);
            textDoctorName.setText(null);
            textDoctorSurname.setText(null);
            textPhoneNumber.setText(null);
            textEmail.setText(null);
            comboDoctorSpeciality.setValue(Doctor.Speciality.OTHER);
            Button closeButton = (Button) event.getSource();
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
            openMainApp(stage);
        }
    }

    /**
     * Opens the main application after adding equipment to the storage.
     *
     * @param stage The stage of the equipment window.
     * @throws IOException if an I/O exception occurs.
     */
    private void openMainApp(Stage stage) throws IOException {
        MainApp mainApp = new MainApp();
        mainApp.start(stage);
    }
}