package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

/**
 * The EquipmentController class controls the interaction with the equipment window.
 */
public class EquipmentController {

    @FXML
    TextField textFieldName;

    @FXML
    TextField textFieldCost;

    @FXML
    TextField textFieldAmount;

    @FXML
    TextField textFieldServiceDate;

    @FXML
    Button submitEquipment;

    /**
     * Adds the equipment to the storage when the submit button is clicked.
     *
     * @param event The action event triggered by the submit button.
     * @throws IOException if an I/O exception occurs.
     * @throws InvalidInputException if any text field is empty.
     */
    @FXML
    protected void addEquipmentToStorage(ActionEvent event) throws IOException {
        if (textFieldName.getText().isEmpty() || textFieldCost.getText().isEmpty() || textFieldAmount.getText().isEmpty()
                || textFieldServiceDate.getText().isEmpty()) {
            throw new InvalidInputException("Fields cannot be empty.");
        } else {
            String name = textFieldName.getText();
            double cost = Double.parseDouble(textFieldCost.getText());
            int amount = Integer.parseInt(textFieldAmount.getText());
            LocalDate serviceDate = LocalDate.parse(textFieldServiceDate.getText());
            Equipment eq = new Equipment(name, cost, amount, serviceDate);
            MainApp.getStorage().addSupply(eq);
            MainApp.getTvObservableList().add(eq);
            textFieldName.setText("");
            textFieldCost.setText("");
            textFieldAmount.setText("");
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
