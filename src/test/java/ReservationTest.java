import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import Project.reservation.Reservation;
import Project.equipment.EquipmentType;
import Project.material.Utility;

public class ReservationTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        String doctorId = "1234";
        LocalDate reservationStart = LocalDate.of(2024, 2, 1);
        LocalDate reservationEnd = LocalDate.of(2024, 2, 5);
        EquipmentType equipmentType = EquipmentType.EKG;
        int equipmentAmount = 2;
        Utility materialType = Utility.STERILIZATION;
        int materialAmount = 100;
        String medicineATC = "A01AA01";
        int medicineAmount = 50;

        // Act
        Reservation reservation = new Reservation(doctorId, reservationStart, reservationEnd,
                equipmentType, equipmentAmount, materialType, materialAmount, medicineATC, medicineAmount);

        // Assert
        assertEquals(doctorId, reservation.getDoctorId());
        assertEquals(reservationStart, reservation.getReservationStart());
        assertEquals(reservationEnd, reservation.getReservationEnd());
        assertEquals(equipmentType.toString(), reservation.getEquipmentType());
        assertEquals(equipmentAmount, reservation.getEquipmentAmount());
        assertEquals(materialType.toString(), reservation.getMaterialType());
        assertEquals(materialAmount, reservation.getMaterialAmount());
        assertEquals(medicineATC, reservation.getMedicineATC());
        assertEquals(medicineAmount, reservation.getMedicineAmount());
    }

    @Test
    public void testSetters() {
        // Arrange
        Reservation reservation = new Reservation("1234", LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 5),
                EquipmentType.EKG, 2, Utility.STERILIZATION, 100, "A01AA01", 50);

        // Act
        reservation.setDoctorId("5678");
        reservation.setReservationStart(LocalDate.of(2024, 3, 1));
        reservation.setReservationEnd(LocalDate.of(2024, 3, 5));
        reservation.setEquipmentType(EquipmentType.USG);
        reservation.setEquipmentAmount(3);
        reservation.setmaterialType(Utility.HEMORRHAGE_CONTROL);
        reservation.setMaterialAmount(200);
        reservation.setMedicineATC("B01AA02");
        reservation.setMedicineAmount(100);

        // Assert
        assertEquals("5678", reservation.getDoctorId());
        assertEquals(LocalDate.of(2024, 3, 1), reservation.getReservationStart());
        assertEquals(LocalDate.of(2024, 3, 5), reservation.getReservationEnd());
        assertEquals(EquipmentType.USG.toString(), reservation.getEquipmentType());
        assertEquals(3, reservation.getEquipmentAmount());
        assertEquals(Utility.HEMORRHAGE_CONTROL.toString(), reservation.getMaterialType());
        assertEquals(200, reservation.getMaterialAmount());
        assertEquals("B01AA02", reservation.getMedicineATC());
        assertEquals(100, reservation.getMedicineAmount());
    }
}