package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The MainController class controls the interaction with the main menu.
 */
public class MainController {

    @FXML
    Button showAddMaterialMenu;

    @FXML
    Button showAddEquipmentMenu;

    @FXML
    Button showAddMedicineMenu;

    @FXML
    Button showStorageMenu;

    /**
     * Handles the action event for showing the fields to add material.
     *
     * @param event The action event triggered by clicking the "Add material" button.
     */
    @FXML
    protected void handleShowFieldsMaterials(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        showFieldsMaterials(stage);
    }

    /**
     * Shows the fields to add material.
     *
     * @param stage The stage of the main menu.
     */
    protected void showFieldsMaterials(Stage stage) {
        try {
            MaterialApp materialApp = new MaterialApp();
            materialApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action event for showing the fields to add equipment.
     *
     * @param event The action event triggered by clicking the "Add equipment" button.
     */
    @FXML
    protected void handleShowFieldsEquipment(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        showFieldsEquipment(stage);
    }

    /**
     * Shows the fields to add equipment.
     *
     * @param stage The stage of the main menu.
     */
    protected void showFieldsEquipment(Stage stage) {
        try {
            EquipmentApp equipmentApp = new EquipmentApp();
            equipmentApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action event for showing the fields to add medicine.
     *
     * @param event The action event triggered by clicking the "Add medicine" button.
     */
    @FXML
    protected void handleShowFieldsMedicine(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        showFieldsMedicine(stage);
    }

    /**
     * Shows the fields to add medicine.
     *
     * @param stage The stage of the main menu.
     */
    protected void showFieldsMedicine(Stage stage) {
        try {
            MedicineApp medicineApp = new MedicineApp();
            medicineApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action event for showing the storage contents.
     *
     * @param event The action event triggered by clicking the "Show storage" button.
     */
    @FXML
    protected void showStorage(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        showStorageContents(stage);
    }

    /**
     * Shows the storage contents.
     *
     * @param stage The stage of the main menu.
     */
    protected void showStorageContents(Stage stage) {
        try {
            StorageApp storageApp = new StorageApp();
            storageApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}