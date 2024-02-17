package Project;

import Project.doctor.Doctor;
import Project.exceptions.InvalidInputException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The SupplyDeletionController class controls the interaction with the doctor deletion window.
 */
public class DeleteDoctorController {
    @FXML
    TextField textFieldKey;

    @FXML
    Button submitDeletion;

    /**
     * Deletes the doctor based on the provided key.
     *
     * @param event The action event triggered by the delete button.
     * @throws IOException if an I/O exception occurs.
     * @throws InvalidInputException if any text field is empty.
     */
    @FXML
    protected void deleteDoctor(ActionEvent event) throws IOException {
        if (textFieldKey.getText().isEmpty()) {
            throw new InvalidInputException("Fields cannot be empty.");
        }
        else {
            int key = Integer.parseInt(textFieldKey.getText());
            Doctor doctor = MainApp.getDoctorsRegister().getSpecialists().get(key);
            MainApp.getDoctorsRegister().deleteSpecialist(key);
            MainApp.getDocObservableList().remove(doctor);
            textFieldKey.setText("");
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
