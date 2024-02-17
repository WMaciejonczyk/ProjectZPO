package Project;

import Project.exceptions.InvalidInputException;
import Project.material.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;


import Project.doctor.Doctor;
import Project.equipment.EquipmentType;

/**
 * The ReservationAppController class controls the interaction with the doctor addition window.
 */
public class ReservationAppController {

    @FXML
    TextField textDoctorID;

    @FXML
    TextField textReservationStart;

    @FXML
    TextField textReservationEnd;

    @FXML
    ComboBox<EquipmentType> equipmentTypeComboBox;

    @FXML
    TextField textEquipmentAmount;

    @FXML
    ComboBox<Utility> materialTypeComboBox;

    @FXML
    TextField textMaterialAmount;

    @FXML
    TextField textMedicineATC;

    @FXML
    TextField textMedicineAmount;

    @FXML
    Button submitReservation;

    /**
     * Adds the Reservation to ReservationRegister when the submit button is clicked.
     *
     * @param event The action event triggered by the submit button.
     * @throws IOException if an I/O exception occurs.
     * @throws InvalidInputException if any text field is empty.
     */
    @FXML
    protected void addReservationToReservationRegister(ActionEvent event) throws IOException {
        if (textDoctorID.getText().isEmpty() || textReservationStart.getText().isEmpty()
                || textReservationEnd.getText().isEmpty() || equipmentTypeComboBox.getValue() == null
                || textEquipmentAmount.getText().isEmpty() || materialTypeComboBox.getValue() == null
                || textMaterialAmount.getText().isEmpty()|| textMedicineATC.getText().isEmpty()
                || textMedicineAmount.getText().isEmpty()){
            throw new InvalidInputException("Fields cannot be empty .");
        } else {
            String id = textDoctorID.getText();
            LocalDate reservationStart = LocalDate.parse(textReservationStart.getText());
            LocalDate reservationEnd = LocalDate.parse(textReservationStart.getText());
            EquipmentType equipmentType = equipmentTypeComboBox.getValue();
            Integer equipmentAmount = Integer.parseInt(textEquipmentAmount.getText());
            Utility materialType = materialTypeComboBox.getValue();
            Integer materialAmount = Integer.parseInt(textMaterialAmount.getText());
            String medicineATC = textMedicineATC.getText();
            Integer medicineAmount = Integer.parseInt(textMedicineAmount.getText());
            if (equipmentAmount < 0 || materialAmount < 0 || medicineAmount < 0) {
                throw new NumberFormatException();}
            if (checkReservation(id, reservationStart, reservationEnd, equipmentType, equipmentAmount, materialType,
                    materialAmount, medicineATC, medicineAmount)) {
                Project.reservation.Reservation reservation = new Project.reservation.Reservation(id, reservationStart, reservationEnd, equipmentType,
                        equipmentAmount, materialType, materialAmount, medicineATC, medicineAmount);
                MainApp.getReservationsRegister().addReservation(reservation);
                MainApp.getResObservableList().add(reservation);
                textDoctorID.setText(null);
                textReservationStart.setText(null);
                textReservationEnd.setText(null);
                equipmentTypeComboBox.setValue(null);
                textEquipmentAmount.setText(null);
                materialTypeComboBox.setValue(null);
                textMaterialAmount.setText(null);
                textMedicineATC.setText(null);
                textMedicineAmount.setText(null);
            }
            else
            {
                throw new InvalidInputException("Not enough equipment, material or medicine in storage.");
            }
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


    public boolean checkReservation(String doctorId, LocalDate reservationStart, LocalDate reservationEnd,
                                    EquipmentType equipmentType, int equipmentAmount,
                                    Utility materialType, int materialAmount,
                                    String medicineATC, int medicineAmount) {

        if (equipmentAmount <= 0 || materialAmount <= 0 || medicineAmount <= 0) {
            return false;
        }
        if (reservationStart.isAfter(reservationEnd)) {
            return false;
        }

        if (checkStorageAvailability(equipmentType, equipmentAmount, materialType, materialAmount, medicineATC, medicineAmount)) {
            return true;
        }
        return false;
    }

    private boolean checkStorageAvailability(EquipmentType equipmentType, int equipmentAmount,
                                             Utility materialType, int materialAmount,
                                             String medicineATC, int medicineAmount) {

        if (! MainApp.getStorage().isEnoughCertainEquipment(equipmentType.toString().toUpperCase(), equipmentAmount)) {
            return false;
        }

        if (! MainApp.getStorage().isEnoughCertainMaterials(materialType.toString().toUpperCase(), materialAmount)) {
            return false;
        }

        if (! MainApp.getStorage().isEnoughCertainMedicine(medicineATC, medicineAmount)) {
            return false;
        }

        return true;
    }

}