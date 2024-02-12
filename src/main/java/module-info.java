module Project {
    requires javafx.controls;
    requires javafx.fxml;


    exports Project;
    opens Project to javafx.fxml;
}