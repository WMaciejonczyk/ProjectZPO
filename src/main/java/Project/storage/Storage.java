package Project.storage;

import Project.equipment.Equipment;
import Project.equipment.EquipmentType;
import Project.material.Materials;
import Project.material.Utility;
import Project.medicine.Medicine;
import Project.supply.Supply;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * The Storage class represents a storage facility for various medical supplies.
 */
public class Storage {
    private TreeMap<Integer, Supply> storage = new TreeMap<>();

    /**
     * Gets the storage map.
     *
     * @return The storage map.
     */
    public TreeMap<Integer, Supply> getStorage() {
        return storage;
    }

    /**
     * Sets the storage map.
     *
     * @param storage The storage map to set.
     */
    public void setStorage(TreeMap<Integer, Supply> storage) {
        this.storage = storage;
    }

    /**
     * Adds a supply item to the storage.
     *
     * @param supply The supply item to add.
     */
    public void addSupply(Supply supply) {
        if (getStorage().isEmpty()) {
            getStorage().put(1, supply);
        } else {
            int key = getStorage().lastKey();
            getStorage().put(key + 1, supply);
        }
    }

    /**
     * Deletes a supply item from the storage.
     *
     * @param key The key of the supply item to delete.
     * @throws IllegalArgumentException if the key is incorrect.
     */
    public void deleteSupply(int key) {
        if (getStorage().containsKey(key)) {
            getStorage().remove(key);
        } else {
            throw new IllegalArgumentException("Incorrect key.");
        }
    }

    /**
     * Updates the cost of a supply item in the storage.
     *
     * @param key  The key of the supply item to update.
     * @param cost The new cost of the supply item.
     * @throws IllegalArgumentException if the key is incorrect or the cost is invalid.
     */
    public void updateSupplyCost(int key, double cost) {
        if (getStorage().containsKey(key) && cost > 0) {
            getStorage().get(key).setCost(cost);
        } else {
            throw new IllegalArgumentException("Incorrect parameters.");
        }
    }

    /**
     * Updates the amount of a supply item in the storage.
     *
     * @param key    The key of the supply item to update.
     * @param amount The new amount of the supply item.
     * @throws IllegalArgumentException if the key is incorrect or the amount is invalid.
     */
    public void updateSupplyAmount(int key, int amount) {
        if (getStorage().containsKey(key) && amount > 0) {
            getStorage().get(key).setAmount(amount);
        } else {
            throw new IllegalArgumentException("Incorrect parameters.");
        }
    }

    /**
     * Updates the expiration or service date of a supply item in the storage.
     *
     * @param key  The key of the supply item to update.
     * @param date The new expiration or service date of the supply item.
     * @throws IllegalArgumentException if the key is incorrect.
     */
    public void updateSupplyExpirationOrServiceDate(int key, LocalDate date) {
        if (getStorage().containsKey(key)) {
            getStorage().get(key).setDate(date);
        } else {
            throw new IllegalArgumentException("Incorrect key.");
        }
    }

    /**
     * Displays the items in the storage.
     *
     * @throws IllegalArgumentException if the storage is empty.
     */
    public void displayItems() {
        if (getStorage().isEmpty()) {
            throw new IllegalArgumentException("Storage is empty.");
        } else {
            TreeMap<Integer, String> displayStorage = new TreeMap<>();
            getStorage().forEach((key, value1) -> {
                String value = value1.getName();
                displayStorage.put(key, value);
            });
            System.out.println(displayStorage);
        }
    }

    /**
     * Checks if there is enough of a certain type of material in the storage.
     *
     * @param utility The utility of the material.
     * @param amount  The required amount of the material.
     * @return True if there is enough material, false otherwise.
     * @throws IllegalArgumentException if the amount is invalid or the utility is incorrect.
     */
    public boolean isEnoughCertainMaterials(String utility, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount input.");
        } else {
            int totalMaterials;
            List<String> list = Arrays.stream(Utility.values()).map(Enum::name).toList();
            if (list.contains(utility)) {
                totalMaterials = getStorage().values().stream()
                        .filter(material -> material instanceof Materials)
                        .map(Materials.class::cast)
                        .filter(material -> material.getUtility() == Utility.valueOf(utility))
                        .mapToInt(Materials::getAmount)
                        .sum();
            } else {
                throw new IllegalArgumentException("Invalid utility input");
            }
            return totalMaterials >= amount;
        }
    }

    /**
     * Checks if there is enough of a certain type of equipment in the storage.
     *
     * @param equipmentType The type of the equipment.
     * @param amount        The required amount of the equipment.
     * @return True if there is enough equipment, false otherwise.
     * @throws IllegalArgumentException if the amount is invalid or the equipment type is incorrect.
     */
    public boolean isEnoughCertainEquipment(String equipmentType, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount input.");
        } else {
            int totalEquipment;
            List<String> list = Arrays.stream(EquipmentType.values()).map(Enum::name).toList();
            if (list.contains(equipmentType)) {
                totalEquipment = getStorage().values().stream()
                        .filter(equipment -> equipment instanceof Equipment)
                        .map(Equipment.class::cast)
                        .filter(equipment -> equipment.getEquipmentType() == EquipmentType.valueOf(equipmentType))
                        .mapToInt(Equipment::getAmount)
                        .sum();
            } else {
                throw new IllegalArgumentException("Invalid equipment type input");
            }
            return totalEquipment >= amount;
        }
    }

    /**
     * Checks if there is enough of a certain type of medicine in the storage.
     *
     * @param medicineGroup The group of the medicine.
     * @param amount        The required amount of the medicine.
     * @return True if there is enough medicine, false otherwise.
     * @throws IllegalArgumentException if the amount is invalid or the medicine group is incorrect.
     */
    public boolean isEnoughCertainMedicine(String medicineGroup, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount input.");
        } else if (medicineGroup.length() != 1) {
            throw new IllegalArgumentException("Invalid medicine group length input.");
        } else {
            int totalMedicine;
            String[] stringArray = {"A", "B", "C", "D", "G", "H", "J", "L", "M", "N", "P", "R", "S", "V"};
            if (Arrays.asList(stringArray).contains(medicineGroup.toUpperCase())) {
                totalMedicine = getStorage().values().stream()
                        .filter(medicine -> medicine instanceof Medicine)
                        .map(Medicine.class::cast)
                        .filter(medicine -> Character.toString(medicine.getClassificationATC().charAt(0)).equals(medicineGroup))
                        .mapToInt(Medicine::getAmount)
                        .sum();
            } else {
                throw new IllegalArgumentException("Invalid medicine group input.");
            }
            return totalMedicine >= amount;
        }
    }
}