package Project.DoctorsRegister;

import Project.doctor.Doctor;

import java.util.TreeMap;

public class DoctorsRegister {
    private TreeMap<Integer, Doctor> specialists = new TreeMap<>();
    public DoctorsRegister() {}

    public TreeMap<Integer, Doctor> getSpecialists() {
        return specialists;
    }

    public void setSpecialists(TreeMap<Integer, Doctor> specialists) {
        this.specialists = specialists;
    }

    public void addSpecialist(Doctor doctor) {
        if (getSpecialists().isEmpty()) {
            getSpecialists().put(1, doctor);
        } else {
            int key = getSpecialists().lastKey();
            getSpecialists().put(key + 1, doctor);
        }
    }

    public void deleteSpecialist(int key) {
        getSpecialists().remove(key);
    }

    public void updatePersonalInfo(int key, String string, String info) {
        string = string.toLowerCase();
        if (string.equals("name")) {
            getSpecialists().get(key).setName(info);
        }
        else if (string.equals("surname")) {
            getSpecialists().get(key).setSurname(info);
        }
        else {
            throw new IllegalArgumentException("Invalid info input");
        }
    }

    public void displaySpecialistInfo(int key) {
        if (getSpecialists().isEmpty()) {
            throw new IllegalArgumentException("No registered doctors.");
        }
        else {
            if (getSpecialists().containsKey(key)) {
                Doctor doctor = getSpecialists().get(key);
                String name = "Name: " + doctor.getName() + "\n";
                String surname = "Surname: " + doctor.getSurname() + "\n";
                String speciality = "Speciality: " + doctor.getSpeciality().name() + "\n";
                String phoneNumber = "Phone number: " + doctor.getPhoneNumber() + "\n";
                String email = "Email: " + doctor.getEmail() + "\n";
                String info = name + surname + speciality + phoneNumber + email;
                System.out.println(info);
            }
            else {
                throw new IllegalArgumentException("Specialist not found.");
            }
        }
    }
}