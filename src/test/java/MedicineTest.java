import Project.Medicine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MedicineTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testCorrectConstructor() {
        Medicine medicine = new Medicine("Paracetamol", "N02BE01", 5.0, 10, LocalDate.now().plusMonths(6));
        assertEquals("Paracetamol", medicine.getName());
        assertEquals("N02BE01", medicine.getClassificationATC());
        assertEquals(5.0, medicine.getCost());
        assertEquals(10, medicine.getAmount());
    }

    @Test
    public void testNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            Medicine medicine = new Medicine("", "N02BE01", 5.0, 10, LocalDate.now().plusMonths(6));
        });
    }

    @Test
    public void testInvalidATCCodeLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            Medicine medicine = new Medicine("Paracetamol", "N02B1", 5.0, 10, LocalDate.now().plusMonths(6));
        });
    }

    @Test
    public void testInvalidATCCodeCategory() {
        assertThrows(IllegalArgumentException.class, () -> {
            Medicine medicine = new Medicine("Paracetamol", "X02BA11", 5.0, 10, LocalDate.now().plusMonths(6));
        });
    }

    @Test
    public void testInvalidATCCodeNumericPart() {
        assertThrows(IllegalArgumentException.class, () -> {
            Medicine medicine = new Medicine("Paracetamol", "N0FBA11", 5.0, 10, LocalDate.now().plusMonths(6));
        });
    }

    @Test
    public void testInvalidATCCodeAlphabeticPart() {
        assertThrows(IllegalArgumentException.class, () -> {
            Medicine medicine = new Medicine("Paracetamol", "N02B411", 5.0, 10, LocalDate.now().plusMonths(6));
        });
    }

    @Test
    public void testSetName() {
        Medicine medicine = new Medicine("Paracetamol", "N02BE01", 5.0, 10, LocalDate.now().plusMonths(6));
        medicine.setName("Ibuprofen");
        assertEquals("Ibuprofen", medicine.getName());
        assertThrows(IllegalArgumentException.class, () -> medicine.setName(""));
    }

    @Test
    public void testSetClassificationATC() {
        Medicine medicine = new Medicine("Paracetamol", "N02BE01", 5.0, 10, LocalDate.now().plusMonths(6));
        medicine.setClassificationATC("A02BC02");
        assertEquals("A02BC02", medicine.getClassificationATC());
        assertThrows(IllegalArgumentException.class, () -> medicine.setClassificationATC(""));
        assertThrows(IllegalArgumentException.class, () -> medicine.setClassificationATC("AB12345"));
        assertThrows(IllegalArgumentException.class, () -> medicine.setClassificationATC("A10V545"));
    }

    @Test
    public void testSetCost() {
        Medicine medicine = new Medicine("Paracetamol", "N02BE01", 5.0, 10, LocalDate.now().plusMonths(6));
        medicine.setCost(6.0);
        assertEquals(6.0, medicine.getCost());
        assertThrows(IllegalArgumentException.class, () -> medicine.setCost(-1));
    }

    @Test
    public void testSetAmount() {
        Medicine medicine = new Medicine("Paracetamol", "N02BE01", 5.0, 10, LocalDate.now().plusMonths(6));
        medicine.setAmount(15);
        assertEquals(15, medicine.getAmount());
        assertThrows(IllegalArgumentException.class, () -> medicine.setAmount(-1));
    }

    @Test
    public void testDisplayInfo() {
        Medicine medicine = new Medicine("Paracetamol", "N02BE01", 5.0, 10, LocalDate.now().plusMonths(6));
        LocalDate date = LocalDate.now().plusMonths(6);
        String info = "ATC: N02BE01\n Name: Paracetamol\n Group: Nervous system\n Cost: 5.0\n Amount: 10\n Expiration date: " + date;
        medicine.displayInfo();
        assertEquals(info, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testIsOverdue() {
        Medicine medicine = new Medicine("Paracetamol", "N02BE01", 5.0, 10, LocalDate.now().plusMonths(6));
        assertFalse(medicine.isOverdue());
        medicine.setDate(LocalDate.now().minusDays(1));
        assertTrue(medicine.isOverdue());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}