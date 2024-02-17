package Project;

import Project.exceptions.InvalidInputException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;


import Project.doctor.Doctor;

/**
 * The ReservationAppControler class controls the interaction with the doctor addition window.
 */
public class ReservationAppControler {

    @FXML
    TextField textDoctorID;

    @FXML
    TextField textReservationStart;

    @FXML
    TextField textReservationEnd;

    @FXML
    TextField textEquipmentName;

    @FXML
    TextField textEquipmentAmount;

    @FXML
    TextField textMaterialName;

    @FXML
    TextField textMaterialAmount;

    @FXML
    TextField textMedicineName;

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
                || textReservationEnd.getText().isEmpty() || textEquipmentName.getText().isEmpty()
                || textEquipmentAmount.getText().isEmpty() || textMaterialName.getText().isEmpty()
                || textMaterialAmount.getText().isEmpty()|| textMedicineName.getText().isEmpty()
                || textMedicineAmount.getText().isEmpty()){
            throw new InvalidInputException("Fields cannot be empty .");
        } else {
            String id = textDoctorID.getText();
            LocalDate reservationStart = LocalDate.parse(textReservationStart.getText());
            LocalDate reservationEnd = LocalDate.parse(textReservationStart.getText());
            String equipmentName = textEquipmentName.getText();
            Integer equipmentAmount = Integer.parseInt(textEquipmentAmount.getText());
            String materialName = textMaterialName.getText();
            Integer materialAmount = Integer.parseInt(textMaterialAmount.getText());
            String medicineName = textMedicineName.getText();
            Integer medicineAmount = Integer.parseInt(textMedicineAmount.getText());
            if (equipmentAmount < 0 || materialAmount < 0 || medicineAmount < 0) {
                throw new NumberFormatException();}
            if (checkReservation(id, reservationStart, reservationEnd, equipmentName, equipmentAmount, materialName,
            materialAmount, medicineName, medicineAmount)) {
                Project.reservation.Reservation reservation = new Project.reservation.Reservation(id, reservationStart, reservationEnd, equipmentName,
                        equipmentAmount, materialName, materialAmount, medicineName, medicineAmount);

                MainApp.getDoctorsRegister().addSpecialist(doc);
                MainApp.getDocObservableList().add(doc);
                textDoctorName.setText(null);
                textDoctorSurname.setText(null);
                textPhoneNumber.setText(null);
                textEmail.setText(null);
                comboDoctorSpeciality.setValue(Doctor.Speciality.OTHER);
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
                                    String equipmentName, int equipmentAmount,
                                    String materialName, int materialAmount,
                                    String medicineName, int medicineAmount) {

        if (equipmentAmount <= 0 || materialAmount <= 0 || medicineAmount <= 0) {
            return false;
        }
        if (reservationStart.isAfter(reservationEnd)) {
            return false;
        }

        if (reservationCollides(equipmentName, reservationStart, reservationEnd)) {
            return false;
        }

        if (checkStorageAvailability(equipmentName, equipmentAmount, materialName, materialAmount, medicineName, medicineAmount)) {
            return false;
        }

        return true;
    }

    private boolean reservationCollides(String equipmentName, LocalDate reservationStart, LocalDate reservationEnd) {
        // Implement collision check logic here

        return false;
    }

    private boolean checkStorageAvailability(String equipmentName, int equipmentAmount,
                                             String materialName, int materialAmount,
                                             String medicineName, int medicineAmount) {
        // Implement storage availability check logic here

        return false;
    }

}