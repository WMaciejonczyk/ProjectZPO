package Project.equipment;

import Project.supply.Supply;

import java.time.LocalDate;

/**
 * This class represents equipment used for medical supplies. It implements the Supply interface.
 */
public class Equipment implements Supply {

    /**
     * Enumeration representing the mobility of equipment.
     */
    public enum Mobility {
        MOVABLE,
        IMMOVABLE,
        UNDETERMINED
    }

    public String name;
    public double cost;
    public int amount;
    public LocalDate serviceDate;
    public EquipmentType equipmentType;
    public Mobility mobility;

    /**
     * Constructs an Equipment object with specified parameters.
     *
     * @param name        The name of the equipment.
     * @param cost        The cost of the equipment.
     * @param amount      The amount of the equipment.
     * @param serviceDate The service date of the equipment.
     * @throws IllegalArgumentException if any of the parameters are invalid (cost <= 0, amount <= 0, or name is empty).
     */
    public Equipment(String name, double cost, int amount, LocalDate serviceDate) {
        if (cost <= 0 || amount <= 0 || name.isEmpty()) {
            throw new IllegalArgumentException("Incorrect parameters.");
        } else {
            this.name = name.toUpperCase();
            this.cost = cost;
            this.amount = amount;
            this.serviceDate = serviceDate;
            setEquipmentType(name.toUpperCase());
            setMobility(name.toUpperCase());
        }
    }

    /**
     * Gets the type of the equipment.
     *
     * @return The type of the equipment.
     */
    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    /**
     * Sets the type of the equipment based on its name.
     *
     * @param name The name of the equipment.
     */
    public void setEquipmentType(String name) {
        switch (name) {
            case "EKG" -> this.equipmentType = EquipmentType.EKG;
            case "RTG" -> this.equipmentType = EquipmentType.RTG;
            case "USG" -> this.equipmentType = EquipmentType.USG;
            case "MRI" -> this.equipmentType = EquipmentType.MRI;
            default -> this.equipmentType = EquipmentType.OTHER;
        }
    }

    /**
     * Gets the mobility of the equipment.
     *
     * @return The mobility of the equipment.
     */
    public Mobility getMobility() {
        return mobility;
    }

    /**
     * Sets the mobility of the equipment based on its name.
     *
     * @param name The name of the equipment.
     */
    public void setMobility(String name) {
        switch (name) {
            case "EKG", "USG" -> this.mobility = Mobility.MOVABLE;
            case "RTG", "MRI" -> this.mobility = Mobility.IMMOVABLE;
            default -> this.mobility = Mobility.UNDETERMINED;
        }
    }

    /**
     * Gets the name of the equipment.
     *
     * @return The name of the equipment.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the equipment.
     *
     * @param name The name of the equipment.
     * @throws IllegalArgumentException if the name is empty.
     */
    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Incorrect name.");
        } else {
            this.name = name.toUpperCase();
            setEquipmentType(name.toUpperCase());
            setMobility(name.toUpperCase());
        }
    }

    /**
     * Gets the cost of the equipment.
     *
     * @return The cost of the equipment.
     */
    @Override
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost of the equipment.
     *
     * @param cost The cost of the equipment.
     * @throws IllegalArgumentException if the cost is less than or equal to zero.
     */
    public void setCost(double cost) {
        if (cost <= 0) {
            throw new IllegalArgumentException("Incorrect cost");
        } else {
            this.cost = cost;
        }
    }

    /**
     * Gets the amount of the equipment.
     *
     * @return The amount of the equipment.
     */
    @Override
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the equipment.
     *
     * @param amount The amount of the equipment.
     * @throws IllegalArgumentException if the amount is less than or equal to zero.
     */
    public void setAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Incorrect amount");
        } else {
            this.amount = amount;
        }
    }

    /**
     * Gets the service date of the equipment.
     *
     * @return The service date of the equipment.
     */
    @Override
    public LocalDate getDate() {
        return serviceDate;
    }

    /**
     * Sets the service date of the equipment.
     *
     * @param serviceDate The service date of the equipment.
     */
    public void setDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    /**
     * Displays information about the equipment.
     */
    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName() + "\n Cost: " + getCost() + "\n Amount: " + getAmount()
                + "\n Service date: " + getDate().toString());
    }

    /**
     * Checks if the equipment's service is valid based on its service date.
     *
     * @return True if the service is valid, false otherwise.
     */
    @Override
    public boolean isOverdue() {
        return !getDate().isAfter(LocalDate.now());
    }
}
