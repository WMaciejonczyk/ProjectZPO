package com.example.projectzpo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HelloController {

    @FXML
    private TableView<Supply> tableView;

    @FXML
    private TableColumn<Supply, Integer> idColumn;

    @FXML
    private TableColumn<Supply, String> nameColumn;

    @FXML
    private TableColumn<Supply, Double> costColumn;

    @FXML
    private TableColumn<Supply, Integer> amountColumn;

    // Add more TableColumn variables based on your Supply class attributes

    @FXML
    private void showStorageDialog() {
        // Implement the logic to show the storage dialog
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Storage Information");
        alert.setHeaderText("Storage Dialog");
        alert.setContentText("Implement your logic to show storage information here.");
        alert.showAndWait();
    }

    public void initializeTable() {
        // Set up the columns
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        costColumn.setCellValueFactory(cellData -> cellData.getValue().getCostProperty().asObject());
        amountColumn.setCellValueFactory(cellData -> cellData.getValue().getAmountProperty().asObject());

        // Add more columns and configure them based on your Supply class attributes

        // Set the table data (you need to replace this with your actual data)
        tableView.getItems().addAll(
                new Supply(1, "Item1", 10.0, 20),
                new Supply(2, "Item2", 15.0, 30),
                new Supply(3, "Item3", 25.0, 15)
                // Add more items based on your Supply class
        );
    }
}