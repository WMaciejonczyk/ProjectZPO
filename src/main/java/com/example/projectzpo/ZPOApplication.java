package com.example.projectzpo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class HelloApplication extends Application {
    private Storage storage;
    private final TableView<Supply> table = new TableView<>();
    private final ObservableList<Supply> tvObservableList = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        // Create a new instance of Storage
        Storage storage = new Storage();

        // Add supplies to the storage
        Materials material = new Materials("Bandage", 20.25, 10, LocalDate.now());
        Equipment equipment = new Equipment("EKG", 1500.00, 1, LocalDate.now());
        Medicine medicine = new Medicine("Fentanyl", "A02WM10", 20.00, 5, LocalDate.now());
        storage.addSupply(material);
        storage.addSupply(equipment);
        storage.addSupply(medicine);

        tvObservableList.addAll(storage.getStorage().values());

        table.setItems(tvObservableList);

        TableColumn<Supply, String> colName = new TableColumn<>("Name");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Supply, Double> colCost = new TableColumn<>("Cost");
        colCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        TableColumn<Supply, Integer> colAmount = new TableColumn<>("Amount");
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        // Retrieve the TableView from the FXML file

        table.getColumns().addAll(colName, colCost, colAmount);


        // Create the showStorage button
        Button showStorageButton = new Button("Show Storage");
        showStorageButton.setOnAction(e -> showStorageDialog());

        // Add the button to the layout
        ((VBox) root.getChildren().get(0)).getChildren().add(showStorageButton);

        // Create the scene and set it on the stage
        Scene scene = new Scene(new Group(table), 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void showStorageDialog() {
        // Create a dialog to show the storage items
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Storage Items");
        dialog.setHeaderText("List of Items in Storage");

        // Create a StringBuilder to build the content
        StringBuilder content = new StringBuilder();

        // Iterate over the storage items and append information
        for (Map.Entry<Integer, Supply> entry : storage.getStorage().entrySet()) {
            Supply supply = entry.getValue();
            content.append("ID: ").append(entry.getKey())
                    .append(", Name: ").append(supply.getName())
                    .append(", Cost: ").append(supply.getCost())
                    .append(", Amount: ").append(supply.getAmount())
                    .append(System.lineSeparator());
        }

        // Create a label to display the content
        Label label = new Label(content.toString());

        // Add the label to the dialog content
        dialog.getDialogPane().setContent(label);

        // Add a close button to the dialog
        ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(closeButton);

        // Show the dialog
        dialog.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}