module Project {
    requires javafx.controls;
    requires javafx.fxml;


    exports Project;
    opens Project to javafx.fxml;
    exports Project.exceptions;
    opens Project.exceptions to javafx.fxml;
    exports Project.equipment;
    opens Project.equipment to javafx.fxml;
    exports Project.medicine;
    opens Project.medicine to javafx.fxml;
    exports Project.supply;
    opens Project.supply to javafx.fxml;
    exports Project.material;
    opens Project.material to javafx.fxml;
    exports Project.storage;
    opens Project.storage to javafx.fxml;
    exports Project.doctor;
    opens Project.doctor to javafx.fxml;
    exports Project.DoctorsRegister;
    opens Project.DoctorsRegister to javafx.fxml;
    exports Project.ReservationsRegister;
    opens  Project.ReservationsRegister to javafx.fxml;
    exports Project.reservation;
    opens Project.reservation to javafx.fxml;
    exports Project.apps;
    opens Project.apps to javafx.fxml;
}