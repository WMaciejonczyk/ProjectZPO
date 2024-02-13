package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

/**
 * The SupplyUpdateController class controls the interaction with the supply update window.
 */
public class SupplyUpdateController {
    @FXML
    TextField textFieldKey;

    @FXML
    TextField textFieldNumber;

    @FXML
    ComboBox<String> selectValue;

    @FXML
    Button submitUpdate;

    /**
     * Updates the supply based on user input.
     *
     * @param event The action event triggered by the update button.
     * @throws IOException if an I/O exception occurs.
     * @throws InvalidInputException if any text field is empty.
     */
    @FXML
    protected void updateSupply(ActionEvent event) throws IOException {
        if (textFieldKey.getText().isEmpty() || selectValue.getValue() == null || textFieldNumber.getText().isEmpty()
                || selectValue.getValue().isEmpty()) {
            throw new InvalidInputException("Fields cannot be empty.");
        }

        else {
            int key = Integer.parseInt(textFieldKey.getText());
            Supply supplyBefore = MainApp.getStorage().getStorage().get(key);
            MainApp.getTvObservableList().remove(supplyBefore);
            if (selectValue.getValue().equalsIgnoreCase("amount")) {
                int amount = Integer.parseInt(textFieldNumber.getText());
                MainApp.getStorage().updateSupplyAmount(key, amount);
                Supply supplyAfter = MainApp.getStorage().getStorage().get(key);
                MainApp.getTvObservableList().add(supplyAfter);
            }
            else if (selectValue.getValue().equalsIgnoreCase("cost")) {
                double cost = Double.parseDouble(textFieldNumber.getText());
                MainApp.getStorage().updateSupplyCost(key, cost);
                Supply supplyAfter = MainApp.getStorage().getStorage().get(key);
                MainApp.getTvObservableList().add(supplyAfter);
            }
            else if (selectValue.getValue().equalsIgnoreCase("termination/service date")) {
                LocalDate date = LocalDate.parse(textFieldNumber.getText());
                MainApp.getStorage().updateSupplyExpirationOrServiceDate(key, date);
                Supply supplyAfter = MainApp.getStorage().getStorage().get(key);
                MainApp.getTvObservableList().add(supplyAfter);
            }
            textFieldKey.setText(null);
            textFieldNumber.setText(null);
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
