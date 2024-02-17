import Project.equipment.Equipment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EquipmentTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testCorrectConstructor() {
        Equipment equipment = new Equipment("EKG", 10000.0, 1, LocalDate.now());
        assertEquals("EKG", equipment.getName());
        assertEquals(10000.0, equipment.getCost());
        assertEquals(1, equipment.getAmount());
        assertEquals(Equipment.EquipmentType.EKG, equipment.getEquipmentType());
        assertEquals(Equipment.Mobility.MOVABLE, equipment.getMobility());
    }

    @Test
    public void testNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            Equipment equipment = new Equipment("", 10000.0, 1, LocalDate.now());
        });
    }

    @Test
    public void testCostIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Equipment equipment = new Equipment("EKG", -10000.0, 1, LocalDate.now());
        });
    }

    @Test
    public void testCostIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Equipment equipment = new Equipment("EKG", 0.0, 1, LocalDate.now());
        });
    }

    @Test
    public void testAmountIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Equipment equipment = new Equipment("EKG", 10000.0, -1, LocalDate.now());
        });
    }

    @Test
    public void testAmountIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Equipment equipment = new Equipment("EKG", 10000.0, 0, LocalDate.now());
        });
    }

    @Test
    public void testSetName() {
        Equipment equipment = new Equipment("EKG", 10000.0, 1, LocalDate.now());
        equipment.setName("RTG");
        assertEquals("RTG", equipment.getName());
        assertEquals(Equipment.EquipmentType.RTG, equipment.getEquipmentType());
        assertThrows(IllegalArgumentException.class, () -> equipment.setName(""));
    }

    @Test
    public void testSetCost() {
        Equipment equipment = new Equipment("EKG", 10000.0, 1, LocalDate.now());
        equipment.setCost(20000.0);
        assertEquals(20000.0, equipment.getCost());
        assertThrows(IllegalArgumentException.class, () -> equipment.setCost(-1));
    }

    @Test
    public void testSetAmount() {
        Equipment equipment = new Equipment("EKG", 10000.0, 1, LocalDate.now());
        equipment.setAmount(2);
        assertEquals(2, equipment.getAmount());
        assertThrows(IllegalArgumentException.class, () -> equipment.setAmount(-1));
    }

    @Test
    public void testDisplayInfo() {
        Equipment equipment = new Equipment("EKG", 10000.0, 1, LocalDate.now());
        LocalDate date = LocalDate.now();
        String info = "Name: EKG\n Cost: 10000.0\n Amount: 1\n Service date: " + date;
        equipment.displayInfo();
        assertEquals(info, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testIsOverdue() {
        Equipment equipment = new Equipment("EKG", 10000.0, 1, LocalDate.now().plusDays(10));
        assertFalse(equipment.isOverdue());
        equipment.setDate(LocalDate.now().minusDays(1));
        assertTrue(equipment.isOverdue());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}