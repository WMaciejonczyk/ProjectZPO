package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

/**
 * The MedicineController class controls the interaction with the medicine window.
 */
public class MedicineController {

    @FXML
    TextField textFieldName;

    @FXML
    TextField textFieldATC;

    @FXML
    TextField textFieldCost;

    @FXML
    TextField textFieldAmount;

    @FXML
    TextField textFieldExpirationDate;

    @FXML
    Button submitMedicine;

    /**
     * Adds the medicine to the storage when the submit button is clicked.
     *
     * @param event The action event triggered by the submit button.
     * @throws IOException if an I/O exception occurs.
     */
    @FXML
    protected void addMedicineToStorage(ActionEvent event) throws IOException {
        if (textFieldName.getText().isEmpty() || textFieldATC.getText().isEmpty() || textFieldCost.getText().isEmpty()
                || textFieldAmount.getText().isEmpty() || textFieldExpirationDate.getText().isEmpty()) {
            throw new InvalidInputException("Fields cannot be empty.");
        } else {
            String name = textFieldName.getText();
            String atc = textFieldATC.getText();
            double cost = Double.parseDouble(textFieldCost.getText());
            int amount = Integer.parseInt(textFieldAmount.getText());
            LocalDate terminationDate = LocalDate.parse(textFieldExpirationDate.getText());
            Medicine medicine = new Medicine(name, atc, cost, amount, terminationDate);
            MainApp.getStorage().addSupply(medicine);
            MainApp.getTvObservableList().add(medicine);
            textFieldName.setText(null);
            textFieldCost.setText(null);
            textFieldAmount.setText(null);
            Button closeButton = (Button) event.getSource();
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
            openMainApp(stage);
        }
    }

    /**
     * Opens the main application after adding medicine to the storage.
     *
     * @param stage The stage of the medicine window.
     * @throws IOException if an I/O exception occurs.
     */
    private void openMainApp(Stage stage) throws IOException {
        MainApp mainApp = new MainApp();
        mainApp.start(stage);
    }
}