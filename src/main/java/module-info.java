module com.example.projectzpo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectzpo to javafx.fxml;
    exports com.example.projectzpo;
}