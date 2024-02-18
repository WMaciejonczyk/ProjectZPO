import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import Project.doctor.Doctor;
import Project.doctor.Speciality;
public class DoctorTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        String name = "John";
        String surname = "Doe";
        Speciality speciality = Speciality.CARDIOLOGY;
        String phoneNumber = "123-456-7890";
        String email = "john.doe@example.com";

        // Act
        Doctor doctor = new Doctor(name, surname, speciality, phoneNumber, email);

        // Assert
        assertEquals(name, doctor.getName());
        assertEquals(surname, doctor.getSurname());
        assertEquals(speciality, doctor.getSpeciality());
        assertEquals(phoneNumber, doctor.getPhoneNumber());
        assertEquals(email, doctor.getEmail());
    }

    @Test
    public void testSetters() {
        // Arrange
        Doctor doctor = new Doctor("John", "Doe", Speciality.CARDIOLOGY, "123-456-7890", "john.doe@example.com");

        // Act
        doctor.setName("Jane");
        doctor.setSurname("Smith");
        doctor.setSpeciality(Speciality.NEUROLOGY);
        doctor.setPhoneNumber("987-654-3210");
        doctor.setEmail("jane.smith@example.com");

        // Assert
        assertEquals("Jane", doctor.getName());
        assertEquals("Smith", doctor.getSurname());
        assertEquals(Speciality.NEUROLOGY, doctor.getSpeciality());
        assertEquals("987-654-3210", doctor.getPhoneNumber());
        assertEquals("jane.smith@example.com", doctor.getEmail());
    }
}