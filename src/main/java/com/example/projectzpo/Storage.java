import java.time.LocalDate;
import java.util.Arrays;
import java.util.TreeMap;
public class Storage {
    private TreeMap<Integer, Supply> storage = new TreeMap<>();
    public Storage() {}

    public TreeMap<Integer, Supply> getStorage() {
        return storage;
    }

    public void setStorage(TreeMap<Integer, Supply> storage) {
        this.storage = storage;
    }

    public void addSupply(Supply supply) {
        if (getStorage().isEmpty()) {
            getStorage().put(1, supply);
        } else {
            int key = getStorage().lastKey();
            getStorage().put(key + 1, supply);
        }
    }

    public void deleteSupply(int key) {
        getStorage().remove(key);
    }

    public void updateSupplyCost(int key, double cost) {
        getStorage().get(key).setCost(cost);
    }

    public void updateSupplyAmount(int key, int amount) {
        getStorage().get(key).setAmount(amount);
    }

    public void updateSupplyTerminationDate(int key, LocalDate date) {
        getStorage().get(key).setDate(date);
    }

    public void displayItems() {
        if (getStorage().isEmpty()) {
            throw new IllegalArgumentException("Storage is empty.");
        }
        else {
            TreeMap<Integer, String> displayStorage = new TreeMap<>();
            getStorage().forEach((key, value1) -> {
                String value = value1.getName();
                displayStorage.put(key, value);
            });
            System.out.println(displayStorage);
        }
    }

    public boolean isEnoughCertainMaterials(String utility, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount input.");
        }
        else {
            int totalMaterials;
            if (Materials.Utility.valueOf(utility).equals(Materials.Utility.HEMORRHAGE_CONTROL)) {
                totalMaterials = getStorage().values().stream()
                        .filter(material -> material instanceof Materials)  // Filter Materials objects
                        .map(Materials.class::cast)  // Cast to Materials
                        .filter(material -> material.getUtility() == Materials.Utility.HEMORRHAGE_CONTROL)
                        .mapToInt(Materials::getAmount)
                        .sum();
            }
            else if (Materials.Utility.valueOf(utility).equals(Materials.Utility.STERILIZATION)) {
                totalMaterials = getStorage().values().stream()
                        .filter(material -> material instanceof Materials)  // Filter Materials objects
                        .map(Materials.class::cast)  // Cast to Materials
                        .filter(material -> material.getUtility() == Materials.Utility.STERILIZATION)
                        .mapToInt(Materials::getAmount)
                        .sum();
            }
            else if (Materials.Utility.valueOf(utility).equals(Materials.Utility.IMMOBILIZATION)) {
                totalMaterials = getStorage().values().stream()
                        .filter(material -> material instanceof Materials)  // Filter Materials objects
                        .map(Materials.class::cast)  // Cast to Materials
                        .filter(material -> material.getUtility() == Materials.Utility.IMMOBILIZATION)
                        .mapToInt(Materials::getAmount)
                        .sum();
            }
            else if (Materials.Utility.valueOf(utility).equals(Materials.Utility.OTHER)) {
                totalMaterials = getStorage().values().stream()
                        .filter(material -> material instanceof Materials)  // Filter Materials objects
                        .map(Materials.class::cast)  // Cast to Materials
                        .filter(material -> material.getUtility() == Materials.Utility.OTHER)
                        .mapToInt(Materials::getAmount)
                        .sum();
            }
            else {
                throw new IllegalArgumentException("Invalid utility input");
            }
            return totalMaterials >= amount;
        }
    }

    public boolean isEnoughCertainEquipment(String equipmentType, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount input.");
        }
        else {
            int totalEquipment;
            if (Equipment.EquipmentType.valueOf(equipmentType).equals(Equipment.EquipmentType.EKG)) {
                totalEquipment = getStorage().values().stream()
                        .filter(equipment -> equipment instanceof Equipment)  // Filter Materials objects
                        .map(Equipment.class::cast)  // Cast to Materials
                        .filter(equipment -> equipment.getEquipmentType() == Equipment.EquipmentType.EKG)
                        .mapToInt(Equipment::getAmount)
                        .sum();
            }
            else if (Equipment.EquipmentType.valueOf(equipmentType).equals(Equipment.EquipmentType.RTG)) {
                totalEquipment = getStorage().values().stream()
                        .filter(equipment -> equipment instanceof Equipment)  // Filter Materials objects
                        .map(Equipment.class::cast)  // Cast to Materials
                        .filter(equipment -> equipment.getEquipmentType() == Equipment.EquipmentType.RTG)
                        .mapToInt(Equipment::getAmount)
                        .sum();
            }
            else if (Equipment.EquipmentType.valueOf(equipmentType).equals(Equipment.EquipmentType.USG)) {
                totalEquipment = getStorage().values().stream()
                        .filter(equipment -> equipment instanceof Equipment)  // Filter Materials objects
                        .map(Equipment.class::cast)  // Cast to Materials
                        .filter(equipment -> equipment.getEquipmentType() == Equipment.EquipmentType.USG)
                        .mapToInt(Equipment::getAmount)
                        .sum();
            }
            else if (Equipment.EquipmentType.valueOf(equipmentType).equals(Equipment.EquipmentType.MRI)) {
                totalEquipment = getStorage().values().stream()
                        .filter(equipment -> equipment instanceof Equipment)  // Filter Materials objects
                        .map(Equipment.class::cast)  // Cast to Materials
                        .filter(equipment -> equipment.getEquipmentType() == Equipment.EquipmentType.MRI)
                        .mapToInt(Equipment::getAmount)
                        .sum();
            }
            else if (Equipment.EquipmentType.valueOf(equipmentType).equals(Equipment.EquipmentType.OTHER)) {
                totalEquipment = getStorage().values().stream()
                        .filter(equipment -> equipment instanceof Equipment)  // Filter Materials objects
                        .map(Equipment.class::cast)  // Cast to Materials
                        .filter(equipment -> equipment.getEquipmentType() == Equipment.EquipmentType.OTHER)
                        .mapToInt(Equipment::getAmount)
                        .sum();
            }
            else {
                throw new IllegalArgumentException("Invalid equipment type input");
            }
            return totalEquipment >= amount;
        }
    }

    public boolean isEnoughCertainMedicine(String medicineGroup, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount input.");
        }
        else if (medicineGroup.length() != 1) {
            throw new IllegalArgumentException("Invalid medicine group length input.");
        }
        else {
            int totalMedicine;
            String[] stringArray = {"A", "B", "C", "D", "G", "H", "J", "L", "M", "N", "P", "R", "S", "V"};
            if (Arrays.asList(stringArray).contains(medicineGroup.toUpperCase())) {
                totalMedicine = getStorage().values().stream()
                        .filter(medicine -> medicine instanceof Medicine)
                        .map(Medicine.class::cast)
                        .filter(medicine -> Character.toString(medicine.getClassificationATC().charAt(0)).equals(medicineGroup))
                        .mapToInt(Medicine::getAmount)
                        .sum();
            }
            else {
                throw new IllegalArgumentException("Invalid medicine group input.");
            }
            return totalMedicine >= amount;
        }
    }
}