# Medical Supplies Management System - JavaFX Application
## Main Menu
- **MainController.java** - class managing the user interaction with the main menu of the application. It provides methods to handle button clicks for different functionalities, such as adding materials, equipment, or medicine, displaying storage contents, deleting supplies, and updating supplies.
- **MainApp.java** - class representing the main application of the project. It initializes the user interface, manages the observable list of supplies, and provides access to the storage instance for managing supplies and resources effectively.
### Storage Module
#### General Interfaces And Custom Exceptions
- **Supply.java** - interface representing a medical supply item. It includes methods for getting and setting the name, cost, amount, and date associated with a supply. It also includes methods for displaying information about a supply and checking if a supply is overdue.
- **InvalidInputException.java** - exception which is thrown while facing problems related to empty textfields in the application.
#### Adding Supplies
##### Materials
- **Materials.java** - class using Supply interface and managing various aspects of medical materials used in healthcare settings. It encapsulates information such as the name, cost, amount, expiration date and utility of the materials.
- **MaterialsController.java** - class serving as a controller for the material window in the application. It manages user input from text fields, validates the input, creates Materials objects based on the input data, adds the materials to the storage, and closes the material window upon submission.
- **MaterialsApp.java** - class initializing and launching the application for adding materials. It sets up the primary stage, loads the material window FXML file, configures the scene, and displays the user interface to allow users to interact with the application.
##### Equipment
- **Equipment.java** - class using Supply interface and managing various aspects of medical equipment used in healthcare settings. It encapsulates information such as the name, cost, amount, service date, type of equipment and its mobility.
- **EquipmentController.java** - class serving as a controller for the equipment window in the application. It manages user input from text fields, validates the input, creates Equipment objects based on the input data, adds the equipment to the storage, and closes the equipment window upon submission.
- **EquipmentApp.java** - class initializing and launching the application for adding equipment. It sets up the primary stage, loads the equipment window FXML file, configures the scene, and displays the user interface to allow users to interact with the application.
##### Medicine
- **Medicine.java** - class using Supply interface and managing various aspects of medical equipment used in healthcare settings. It encapsulates information such as the name, ATC code, cost, amount and expiration date.
- **MedicineController.java** - class serving as a controller for the medicine window in the application. It manages user input from text fields, validates the input, creates Medicine objects based on the input data, adds the medicine to the storage, and closes the medicine window upon submission.
- **MedicineApp.java** - class initializing and launching the application for adding medicine. It sets up the primary stage, loads the medicine window FXML file, configures the scene, and displays the user interface to allow users to interact with the application.
#### Deleting Supplies
- **SupplyDeletionController.java** - class controlling the interaction with the supply deletion window. It validates user input, performs supply deletion based on the provided key, updates the storage, and refreshes the user interface to reflect the changes.
- **SupplyDeletionApp.java** - class initializing and launching the application for deleting supplies. It sets up the primary stage, loads the deletion window FXML file, configures the scene, and displays the user interface to allow users to interact with the application.
#### Updating Supplies
- **SupplyUpdateController.java** - class controlling the interaction with the supply update window. It validates user input, performs supply updates based on the selected attribute (amount, cost, expiration/service date), updates the storage, and refreshes the user interface to reflect the changes.
- **SupplyUpdateApp.java** - class initializing and launching the application for updating supplies. It sets up the primary stage, loads the update window FXML file, configures the scene, and displays the user interface to allow users to interact with the application.
#### Showing Storage Contents
- **Storage.java** - class serving as a container for storing different types of medical supplies. It utilizes a TreeMap data structure to organize supplies by unique keys. It offers methods to add, delete, update, and display supplies, as well as functionalities to check the availability of certain types of supplies within the storage.
- **StorageController.java** - class controlling the interaction with the storage window. It is used to manage the display of stored supplies. It is initialized when the storage window is loaded and provides functionality to exit the storage window and return to the main application.
- **StorageApp.java** - class initializing and launching the application for displaying stored supplies. It sets up the primary stage, loads the storage window FXML file, configures the scene, and displays table consisting of storaged items and its corresponding information.
#### Tests
- **MaterialsTest.java** - class used to ensure that the Materials class behaves as expected in various scenarios, helping maintain the integrity and correctness of the application's logic.
- **EquipmentTest.java** - class used to ensure that the Equipment class behaves as expected in various scenarios, helping maintain the integrity and correctness of the application's logic.
- **MedicineTest.java** - class used to ensure that the Medicine class behaves as expected in various scenarios, helping maintain the integrity and correctness of the application's logic.
- **StorageTest.java** - class used to ensure that the Storage class behaves as expected in various scenarios, helping maintain the integrity and correctness of the application's logic.