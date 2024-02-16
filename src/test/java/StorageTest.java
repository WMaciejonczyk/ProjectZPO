import Project.equipment.Equipment;
import Project.material.Materials;
import Project.medicine.Medicine;
import Project.storage.Storage;
import Project.supply.Supply;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class StorageTest {
    private Storage storage;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        storage = new Storage();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testSetStorage() {
        TreeMap<Integer, Supply> newStorage = new TreeMap<>();
        Materials material1 = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        Materials material2 = new Materials("Gauze", 15.0, 7, LocalDate.now().plusDays(5));
        newStorage.put(1, material1);
        newStorage.put(2, material2);

        storage.setStorage(newStorage);

        assertEquals(2, storage.getStorage().size());
        assertTrue(storage.getStorage().containsValue(material1));
        assertTrue(storage.getStorage().containsValue(material2));
    }

    @Test
    public void testAddSupply() {
        Materials material = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        storage.addSupply(material);
        TreeMap<Integer, Supply> storageMap = storage.getStorage();
        assertEquals(1, storageMap.size());
        assertTrue(storageMap.containsValue(material));
    }

    @Test
    public void testDeleteSupplyIncorrectKey() {
        Materials material = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        storage.addSupply(material);
        assertThrows(IllegalArgumentException.class, () -> storage.deleteSupply(10));
    }

    @Test
    public void testDeleteSupply() {
        Materials material = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        storage.addSupply(material);
        storage.deleteSupply(1);
        assertTrue(storage.getStorage().isEmpty());
    }

    @Test
    public void testUpdateSupplyCostIncorrectKey() {
        Materials material = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        storage.addSupply(material);
        assertThrows(IllegalArgumentException.class, () -> storage.updateSupplyCost(10, 15.0));
    }

    @Test
    public void testUpdateSupplyCostIncorrectCost() {
        Materials material = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        storage.addSupply(material);
        assertThrows(IllegalArgumentException.class, () -> storage.updateSupplyCost(1, -15.0));
    }

    @Test
    public void testUpdateSupplyCost() {
        Materials material = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        storage.addSupply(material);
        storage.updateSupplyCost(1, 15.0);
        assertEquals(15.0, material.getCost());
    }

    @Test
    public void testUpdateSupplyAmountIncorrectKey() {
        Materials material = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        storage.addSupply(material);
        assertThrows(IllegalArgumentException.class, () -> storage.updateSupplyAmount(10, 15));
    }

    @Test
    public void testUpdateSupplyAmountIncorrectAmount() {
        Materials material = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        storage.addSupply(material);
        assertThrows(IllegalArgumentException.class, () -> storage.updateSupplyAmount(1, -15));
    }

    @Test
    public void testUpdateSupplyAmount() {
        Materials material = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        storage.addSupply(material);
        storage.updateSupplyAmount(1, 10);
        assertEquals(10, material.getAmount());
    }

    @Test
    public void testUpdateSupplyTerminationOrServiceDateIncorrectKey() {
        Materials material = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        storage.addSupply(material);
        LocalDate newDate = LocalDate.now().plusDays(20);
        assertThrows(IllegalArgumentException.class, () -> storage.updateSupplyExpirationOrServiceDate(10, newDate));
    }


    @Test
    public void testUpdateSupplyTerminationOrServiceDate() {
        Materials material = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        storage.addSupply(material);
        LocalDate newDate = LocalDate.now().plusDays(20);
        storage.updateSupplyExpirationOrServiceDate(1, newDate);
        assertEquals(newDate, material.getDate());
    }

    @Test
    public void testDisplayItemsWhenEmpty() {
        assertThrows(IllegalArgumentException.class, () -> storage.displayItems());
    }
    @Test
    public void testDisplayItems() {
        Materials material1 = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        Materials material2 = new Materials("Gauze", 15.0, 7, LocalDate.now().plusDays(5));
        storage.addSupply(material1);
        storage.addSupply(material2);
        String info = "{1=Bandages, 2=Gauze}";
        storage.displayItems();
        assertEquals(info, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testIsEnoughCertainMaterialsWhenAmountIsZero() {
        assertThrows(IllegalArgumentException.class, () -> storage.isEnoughCertainMaterials("HEMORRHAGE_CONTROL", 0));
    }

    @Test
    public void testIsEnoughCertainMaterialsWhenAmountIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> storage.isEnoughCertainMaterials("HEMORRHAGE_CONTROL", -5));
    }

    @Test
    public void testIsEnoughCertainMaterialsIncorrectUtility() {
        Materials material1 = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        Materials material2 = new Materials("Gauze", 15.0, 7, LocalDate.now().plusDays(5));
        storage.addSupply(material1);
        storage.addSupply(material2);
        assertThrows(IllegalArgumentException.class, () -> storage.isEnoughCertainMaterials("", 20));
    }

    @Test
    public void testIsEnoughCertainMaterials() {
        Materials material1 = new Materials("Bandages", 10.0, 5, LocalDate.now().plusDays(10));
        Materials material2 = new Materials("Gauze", 15.0, 7, LocalDate.now().plusDays(5));
        storage.addSupply(material1);
        storage.addSupply(material2);
        assertTrue(storage.isEnoughCertainMaterials("HEMORRHAGE_CONTROL", 5));
        assertFalse(storage.isEnoughCertainMaterials("HEMORRHAGE_CONTROL", 15));
    }

    @Test
    public void testIsEnoughCertainEquipmentWhenAmountIsZero() {
        assertThrows(IllegalArgumentException.class, () -> storage.isEnoughCertainEquipment("EKG", 0));
    }

    @Test
    public void testIsEnoughCertainEquipmentWhenAmountIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> storage.isEnoughCertainEquipment("EKG", -5));
    }

    @Test
    public void testIsEnoughCertainEquipmentIncorrectEquipmentType() {
        Equipment equipment1 = new Equipment("EKG", 5000.0, 2, LocalDate.now().plusYears(5));
        Equipment equipment2 = new Equipment("USG", 8000.0, 1, LocalDate.now().plusYears(3));
        storage.addSupply(equipment1);
        storage.addSupply(equipment2);
        assertThrows(IllegalArgumentException.class, () -> storage.isEnoughCertainEquipment("", 20));
    }

    @Test
    public void testIsEnoughCertainEquipment() {
        Equipment equipment1 = new Equipment("EKG", 5000.0, 2, LocalDate.now().plusYears(5));
        Equipment equipment2 = new Equipment("USG", 8000.0, 1, LocalDate.now().plusYears(3));
        storage.addSupply(equipment1);
        storage.addSupply(equipment2);
        assertTrue(storage.isEnoughCertainEquipment("EKG", 1));
        assertFalse(storage.isEnoughCertainEquipment("USG", 2));
    }

    @Test
    public void testIsEnoughCertainMedicineWhenAmountIsZero() {
        assertThrows(IllegalArgumentException.class, () -> storage.isEnoughCertainMedicine("N", 0));
    }

    @Test
    public void testIsEnoughCertainMedicineWhenAmountIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> storage.isEnoughCertainMedicine("N", -5));
    }

    @Test
    public void testIsEnoughCertainMedicineIncorrectMedicineGroupLength() {
        Medicine medicine1 = new Medicine("Paracetamol", "N02BE01", 5.0, 10, LocalDate.now().plusMonths(6));
        Medicine medicine2 = new Medicine("Ibuprofen", "M01AE01", 7.0, 8, LocalDate.now().plusMonths(8));
        storage.addSupply(medicine1);
        storage.addSupply(medicine2);
        assertThrows(IllegalArgumentException.class, () -> storage.isEnoughCertainMedicine("", 20));
    }

    @Test
    public void testIsEnoughCertainMedicineIncorrectMedicineGroup() {
        Medicine medicine1 = new Medicine("Paracetamol", "N02BE01", 5.0, 10, LocalDate.now().plusMonths(6));
        Medicine medicine2 = new Medicine("Ibuprofen", "M01AE01", 7.0, 8, LocalDate.now().plusMonths(8));
        storage.addSupply(medicine1);
        storage.addSupply(medicine2);
        assertThrows(IllegalArgumentException.class, () -> storage.isEnoughCertainMedicine("E", 20));
    }

    @Test
    public void testIsEnoughCertainMedicine() {
        Medicine medicine1 = new Medicine("Paracetamol", "N02BE01", 5.0, 10, LocalDate.now().plusMonths(6));
        Medicine medicine2 = new Medicine("Ibuprofen", "M01AE01", 7.0, 8, LocalDate.now().plusMonths(8));
        storage.addSupply(medicine1);
        storage.addSupply(medicine2);
        assertTrue(storage.isEnoughCertainMedicine("N", 5));
        assertFalse(storage.isEnoughCertainMedicine("M", 10));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}