package Project;

import Project.apps.*;
import Project.supply.SupplyDeletionApp;
import Project.supply.SupplyUpdateApp;
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

    @FXML
    Button deleteSupplyMenu;

    @FXML
    Button updateSupplyMenu;

    @FXML
    Button showAddDoctorMenu;

    @FXML
    Button DeleteDoctorMenu;

    @FXML
    Button showDoctors;

    @FXML
    Button showReservationMenu;

    @FXML
    Button deleteReservationMenu;

    @FXML
    Button showReservations;


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

    /**
     * Handles the action event for showing the fields for supply deletion.
     *
     * @param event The action event triggered by clicking the "Delete supply" button.
     */
    @FXML
    protected void handleShowFieldsSupplyDeletion(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        showFieldsSupplyDeletion(stage);
    }

    /**
     * Show the fields to delete supply.
     *
     * @param stage The stage of the main menu.
     */
    protected void showFieldsSupplyDeletion(Stage stage) {
        try {
            SupplyDeletionApp supplyUpdateApp = new SupplyDeletionApp();
            supplyUpdateApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action event for showing the fields for supply update.
     *
     * @param event The action event triggered by clicking the "Update supply" button.
     */
    @FXML
    protected void handleShowFieldsSupplyUpdate(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        showFieldsSupplyUpdate(stage);
    }

    /**
     * Show the fields to update supply.
     *
     * @param stage The stage of the main menu.
     */
    protected void showFieldsSupplyUpdate(Stage stage) {
        try {
            SupplyUpdateApp supplyUpdateApp = new SupplyUpdateApp();
            supplyUpdateApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action event for showing the add doctor menu.
     *
     * @param event The action event triggered by clicking the "Add Doctor" button.
     */
    @FXML
    protected void handleShowAddDoctorMenu(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        showAddDoctorMenu(stage);
    }

    /**
     * Shows the add doctor menu.
     *
     * @param stage The stage of the main menu.
     */
    protected void showAddDoctorMenu(Stage stage) {
        try {
            AddDoctorApp addDoctorApp = new AddDoctorApp();
            addDoctorApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action event for showing the delete doctor menu.
     *
     * @param event The action event triggered by clicking the "Delete Doctor" button.
     */
    @FXML
    protected void handleShowDeleteDoctorMenu(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        showDeleteDoctorMenu(stage);
    }

    /**
     * Shows the delete doctor menu.
     *
     * @param stage The stage of the main menu.
     */
    protected void showDeleteDoctorMenu(Stage stage) {
        try {
            DeleteDoctorApp deleteDoctorApp = new DeleteDoctorApp();
            deleteDoctorApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action event for showing the list of employed doctors.
     *
     * @param event The action event triggered by clicking the "Show Doctors" button.
     */
    @FXML
    protected void handleShowDoctorsRegister(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        showDoctors(stage);
    }

    /**
     * Shows the employed doctors.
     *
     * @param stage The stage of the main menu.
     */
    protected void showDoctors(Stage stage) {
        try {
            DoctorsRegisterApp doctorsRegisterApp = new DoctorsRegisterApp();
            doctorsRegisterApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Handles the action event for showing the reservation menu.
     *
     * @param event The action event triggered by clicking the "Show Reservation" button.
     */
    @FXML
    protected void handleShowReservationMenu(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        showReservationMenu(stage);
    }

    /**
     * Shows the reservation menu
     *
     * @param stage The stage of the main menu.
     */
    protected void showReservationMenu(Stage stage) {
        try {
            ReservationApp reservationApp = new ReservationApp();
            reservationApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Handles the action event for showing reservations.
     *
     * @param event The action event triggered by clicking the "Show Reservations" button.
     */
    @FXML
    protected void handleShowReservations(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        showReservations(stage);
    }

    /**
     * Shows the reservations.
     *
     * @param stage The stage of the main menu.
     */
    protected void showReservations(Stage stage) {
        try {
            ReservationRegisterApp reservationRegisterApp = new ReservationRegisterApp();
            reservationRegisterApp.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}