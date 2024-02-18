package Project.doctor;

/**
 * Represents a Doctor with name, surname, speciality, phone number, and email.
 */
public class Doctor {
    private String name;
    private String surname;
    private Speciality speciality;
    private String phoneNumber;
    private String email;

    /**
     * Constructs a Doctor with the specified details.
     *
     * @param name        The name of the doctor.
     * @param surname     The surname of the doctor.
     * @param speciality  The speciality of the doctor.
     * @param phoneNumber The phone number of the doctor.
     * @param email       The email of the doctor.
     */
    public Doctor(String name, String surname, Speciality speciality, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Gets the name of the doctor.
     *
     * @return The name of the doctor.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the doctor.
     *
     * @param name The name of the doctor to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the surname of the doctor.
     *
     * @return The surname of the doctor.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the doctor.
     *
     * @param surname The surname of the doctor to set.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the speciality of the doctor.
     *
     * @return The speciality of the doctor.
     */
    public Speciality getSpeciality() {
        return speciality;
    }

    /**
     * Sets the speciality of the doctor.
     *
     * @param speciality The speciality of the doctor to set.
     */
    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    /**
     * Gets the phone number of the doctor.
     *
     * @return The phone number of the doctor.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the doctor.
     *
     * @param phoneNumber The phone number of the doctor to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the email of the doctor.
     *
     * @return The email of the doctor.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the doctor.
     *
     * @param email The email of the doctor to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}