package Project.DoctorsRegister;

import Project.doctor.Doctor;

import java.util.TreeMap;

/**
 * Manages a register of doctors.
 */
public class DoctorsRegister {
    private TreeMap<Integer, Doctor> specialists = new TreeMap<>();

    /**
     * Gets the TreeMap of specialists.
     *
     * @return The TreeMap of specialists.
     */
    public TreeMap<Integer, Doctor> getSpecialists() {
        return specialists;
    }

    /**
     * Sets the TreeMap of specialists.
     *
     * @param specialists The TreeMap of specialists to set.
     */
    public void setSpecialists(TreeMap<Integer, Doctor> specialists) {
        this.specialists = specialists;
    }

    /**
     * Adds a specialist to the register.
     *
     * @param doctor The doctor to add.
     */
    public void addSpecialist(Doctor doctor) {
        if (getSpecialists().isEmpty()) {
            getSpecialists().put(1, doctor);
        } else {
            int key = getSpecialists().lastKey();
            getSpecialists().put(key + 1, doctor);
        }
    }

    /**
     * Deletes a specialist from the register.
     *
     * @param key The key of the doctor to delete.
     * @throws IllegalArgumentException If the specified key is incorrect.
     */
    public void deleteSpecialist(int key) {
        if (getSpecialists().containsKey(key)) {
            getSpecialists().remove(key);
        } else {
            throw new IllegalArgumentException("Incorrect key.");
        }
    }

    /**
     * Updates personal information of a specialist.
     *
     * @param key   The key of the doctor to update.
     * @param string The type of information to update (e.g., "name" or "surname").
     * @param info  The new information.
     * @throws IllegalArgumentException If the specified information input is invalid.
     */
    public void updatePersonalInfo(int key, String string, String info) {
        string = string.toLowerCase();
        if (string.equals("name")) {
            getSpecialists().get(key).setName(info);
        } else if (string.equals("surname")) {
            getSpecialists().get(key).setSurname(info);
        } else {
            throw new IllegalArgumentException("Invalid info input");
        }
    }

    /**
     * Displays information of a specialist.
     *
     * @param key The key of the doctor to display information for.
     * @throws IllegalArgumentException If no registered doctors are found or if the specified specialist is not found.
     */
    public void displaySpecialistInfo(int key) {
        if (getSpecialists().isEmpty()) {
            throw new IllegalArgumentException("No registered doctors.");
        } else {
            if (getSpecialists().containsKey(key)) {
                Doctor doctor = getSpecialists().get(key);
                String name = "Name: " + doctor.getName() + "\n";
                String surname = "Surname: " + doctor.getSurname() + "\n";
                String speciality = "Speciality: " + doctor.getSpeciality().name() + "\n";
                String phoneNumber = "Phone number: " + doctor.getPhoneNumber() + "\n";
                String email = "Email: " + doctor.getEmail() + "\n";
                String info = name + surname + speciality + phoneNumber + email;
                System.out.println(info);
            } else {
                throw new IllegalArgumentException("Specialist not found.");
            }
        }
    }
}