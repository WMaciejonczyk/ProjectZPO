package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

/**
 * The MaterialController class controls the interaction with the material window.
 */
public class MaterialController {

    @FXML
    TextField textFieldName;

    @FXML
    TextField textFieldCost;

    @FXML
    TextField textFieldAmount;

    @FXML
    TextField textFieldExpirationDate;

    @FXML
    Button submitMaterial;

    /**
     * Adds the material to the storage when the submit button is clicked.
     *
     * @param event The action event triggered by the submit button.
     * @throws IOException if an I/O exception occurs.
     */
    @FXML
    protected void addMaterialToStorage(ActionEvent event) throws IOException {
        if (textFieldName.getText().isEmpty() || textFieldCost.getText().isEmpty() || textFieldAmount.getText().isEmpty()
                || textFieldExpirationDate.getText().isEmpty()) {
            throw new InvalidInputException("Fields cannot be empty.");
        } else {
            String name = textFieldName.getText();
            double cost = Double.parseDouble(textFieldCost.getText());
            int amount = Integer.parseInt(textFieldAmount.getText());
            LocalDate terminationDate = LocalDate.parse(textFieldExpirationDate.getText());
            Materials material = new Materials(name, cost, amount, terminationDate);
            MainApp.getStorage().addSupply(material);
            MainApp.getTvObservableList().add(material);
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
     * Opens the main application after adding material to the storage.
     *
     * @param stage The stage of the material window.
     * @throws IOException if an I/O exception occurs.
     */
    private void openMainApp(Stage stage) throws IOException {
        MainApp mainApp = new MainApp();
        mainApp.start(stage);
    }
}
