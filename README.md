# Medical Supplies Management System - JavaFX Application
## Main Menu
- **MainController.java** - class managing the user interaction with the main menu of the application. It provides methods to handle button clicks for different functionalities, such as adding materials, equipment, or medicine, displaying storage contents, deleting supplies, updating supplies, adding and deleting doctors, adding reservations, displaying both doctors' register and reservations' register.
- **MainApp.java** - class representing the main application of the project. It initializes the user interface, manages the observable list of supplies, doctors and reservations, provides access to the storage instance for managing supplies and also giving user an access to both doctors' register and reservations' register for managing personnel and their corresponding planned operations dependant on the proper use of resources from storage.
### Storage Module
#### General Interfaces, Custom Exceptions, Adapters
- **Supply.java** - interface representing a medical supply item. It includes methods for getting and setting the name, cost, amount, and date associated with a supply. It also includes methods for displaying information about a supply and checking if a supply is overdue.
- **InvalidInputException.java** - exception which is thrown while facing problems related to empty textfields in the application.
- **LocalDateAdapter.java** - class representing a JSON adapter for serializing and deserializing LocalDate objects.
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
- **StorageExporter.java** - Handles the exporting of storage data to a JSON file, ensuring that storage contents can be saved and accessed efficiently.
### Doctors Module
##### Doctors
- **Doctor.java** - Represents a doctor with essential details such as name, surname, speciality, phone number, and email, enabling effective management of doctor information within the application.
- **Speciality.java** - Defines the possible specializations that a doctor can have, providing a structured way to categorize and manage doctors based on their areas of expertise.
##### DoctorsRegister
- **DoctorsRegister.java** - Manages a register of doctors, allowing for the addition, deletion, and retrieval of doctor records within the application's database.
- **DoctorsRegisterController.java** - Controls the interaction between the user interface and the doctors register, facilitating the execution of various actions related to doctor management.
- **DoctorsRegisterApp.java** - Initializes and launches the application for managing doctors, providing a user-friendly interface for interacting with doctor records and performing necessary operations.
#### Adding Doctors
- **AddDoctorController.java** - Manages user input and actions related to adding new doctor records, ensuring the integrity and correctness of the data entered into the application's database.
- **AddDoctorApp.java** - Initializes and launches the application for adding new doctors, presenting users with a dedicated interface for entering doctor details and saving them to the database.
#### Deleting Doctors
- **DeleteDoctorController.java** - Handles user interactions and commands for deleting existing doctor records from the application's database, ensuring proper validation and execution of deletion operations.
- **DeleteDoctorApp.java** - Initializes and launches the application for deleting existing doctors, providing users with an interface to select and remove doctor records from the database securely.
### Reservations Module
##### Reservations
- **Reservation.java** - Represents a reservation for equipment, material, and medicine by a doctor, encapsulating essential details such as reservation dates and quantities for each resource type.
- **ReservationApp.java** - Initializes and launches the application for managing reservations, offering users a convenient interface for creating, updating, and deleting reservation records.
- **ReservationAppController.java** - Acts as an intermediary between the user interface and reservation management system, facilitating user interactions and executing actions related to reservation operations.
##### ReservationsRegister
- **ReservationRegister.java** - Manages a register of reservations, enabling the organization and retrieval of reservation records based on various criteria within the application's database.
- **ReservationRegisterApp.java** - Initializes and launches the application for viewing reservation records, presenting users with a comprehensive overview of reservations stored in the database.
- **ReservationRegisterAppController.java** - Coordinates interactions between the user interface and reservation register, responding to user commands and updating the display of reservation records accordingly.
- **ReservationRegisterExporter.java** - Handles the exporting of reservation data to external files, facilitating data backup and transfer operations for enhanced data management and portability.
#### Tests
- **MaterialsTest.java** - class used to ensure that the Materials class behaves as expected in various scenarios, helping maintain the integrity and correctness of the application's logic.
- **EquipmentTest.java** - class used to ensure that the Equipment class behaves as expected in various scenarios, helping maintain the integrity and correctness of the application's logic.
- **MedicineTest.java** - class used to ensure that the Medicine class behaves as expected in various scenarios, helping maintain the integrity and correctness of the application's logic.
- **StorageTest.java** - class used to ensure that the Storage class behaves as expected in various scenarios, helping maintain the integrity and correctness of the application's logic.
- **DoctorTest.java** - tests the Doctor class to ensure proper initialization and manipulation of doctor details like name, surname, speciality, phone number, and email.
- **ReservationTest.java** - validates the functionality of the Reservation class, confirming correct initialization and manipulation of reservation details including doctor ID, dates, equipment, material, and medicine reservations.
