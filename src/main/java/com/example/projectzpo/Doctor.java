public class Doctor {
    public enum Speciality {
        CARDIOLOGY,
        ORTHOPEDICS,
        ENDOCRINOLOGY,
        NEUROLOGY,
        OTHER
    }
    private String name;
    private String surname;
    private Speciality speciality;
    private String phoneNumber;
    private String email;

    public Doctor(String name, String surname, Speciality speciality, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
