import Project.material.Materials;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MaterialsTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void testCorrectConstructor() {
        Materials m = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        assertEquals("Bandages", m.getName());
        assertEquals(10.0, m.getCost());
        assertEquals(5, m.getAmount());
        assertEquals(Materials.Utility.HEMORRHAGE_CONTROL, m.getUtility());
    }

    @Test
    public void testNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            Materials material = new Materials("", 20.00, 2, LocalDate.now());
        });
    }
    @Test
    public void testCostIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Materials material = new Materials("bandages", -2.05, 2, LocalDate.now());
        });
    }

    @Test
    public void testCostIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Materials material = new Materials("bandages", 0.00, 2, LocalDate.now());
        });
    }

    @Test
    public void testAmountIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Materials material = new Materials("bandages", 20.00, -6, LocalDate.now());
        });
    }

    @Test
    public void testAmountIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Materials material = new Materials("bandages", 20.00, 0, LocalDate.now());
        });
    }

    @Test
    public void testSetName() {
        Materials m = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        m.setName("Gauze");
        assertEquals("Gauze", m.getName());
        assertEquals(Materials.Utility.STERILIZATION, m.getUtility());
        assertThrows(IllegalArgumentException.class, () -> m.setName(""));
    }
    @Test
    public void testSetCost() {
        Materials m = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        m.setCost(20.0);
        assertEquals(20.0, m.getCost());
        assertThrows(IllegalArgumentException.class, () -> m.setCost(-1));
    }

    @Test
    public void testSetAmount() {
        Materials m = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        m.setAmount(10);
        assertEquals(10, m.getAmount());
        assertThrows(IllegalArgumentException.class, () -> m.setAmount(-1));
    }

    @Test
    public void testSetUtilityHemorrhageControl() {
        Materials m = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        m.setUtility("Bandages");
        assertEquals(Materials.Utility.HEMORRHAGE_CONTROL, m.getUtility());
    }

    @Test
    public void testSetUtilitySterilization() {
        Materials m = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        m.setUtility("Gauze");
        assertEquals(Materials.Utility.STERILIZATION, m.getUtility());
    }

    @Test
    public void testSetUtilityImmobilization() {
        Materials m = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        m.setUtility("Plaster");
        assertEquals(Materials.Utility.IMMOBILIZATION, m.getUtility());
    }

    @Test
    public void testSetUtilityOther() {
        Materials m = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        m.setUtility("First aid kit");
        assertEquals(Materials.Utility.OTHER, m.getUtility());
    }

    @Test
    public void testDisplayInfo() {
        Materials m = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        LocalDate date = LocalDate.now().plusDays(10);
        String info = "Name: Bandages\n Purpose: HEMORRHAGE_CONTROL\n Cost: 10.0\n Amount: 5\n Expiration date: " + date;
        m.displayInfo();
        assertEquals(info, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testIsOverdue() {
        Materials m = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        assertFalse(m.isOverdue());
        m.setDate(LocalDate.now().minusDays(1));
        assertTrue(m.isOverdue());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}