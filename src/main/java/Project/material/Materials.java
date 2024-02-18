package Project.material;

import Project.supply.Supply;

import java.time.LocalDate;

/**
 * This class represents materials used for medical supplies. It implements the Supply interface.
 */
public class Materials implements Supply {
    public String name;
    public double cost;
    public int amount;
    public LocalDate expirationDate;
    public Utility utility;

    /**
     * Constructs a Materials object with specified parameters.
     *
     * @param name            The name of the material.
     * @param cost            The cost of the material.
     * @param amount          The amount of the material.
     * @param expirationDate The expiration date of the material.
     * @throws IllegalArgumentException if any of the parameters are invalid (cost <= 0, amount <= 0, or name is empty).
     */
    public Materials(String name, double cost, int amount, LocalDate expirationDate) {
        if (cost <= 0 || amount <= 0 || name.isEmpty()) {
            throw new IllegalArgumentException("Incorrect parameters.");
        } else {
            this.name = name;
            this.cost = cost;
            this.amount = amount;
            this.expirationDate = expirationDate;
            setUtility(getName());
        }
    }

    /**
     * Gets the utility of the material.
     *
     * @return The utility of the material.
     */
    public Utility getUtility() {
        return utility;
    }

    /**
     * Sets the utility of the material based on its name.
     *
     * @param name The name of the material.
     */
    public void setUtility(String name) {
        switch (name.toUpperCase()) {
            case "BANDAGES" -> this.utility = Utility.HEMORRHAGE_CONTROL;
            case "GAUZE" -> this.utility = Utility.STERILIZATION;
            case "PLASTER" -> this.utility = Utility.IMMOBILIZATION;
            default -> this.utility = Utility.OTHER;
        }
    }

    /**
     * Gets the name of the material.
     *
     * @return The name of the material.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the material.
     *
     * @param name The name of the material.
     * @throws IllegalArgumentException if the name is empty.
     */
    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Incorrect name.");
        } else {
            this.name = name;
            setUtility(name);
        }
    }

    /**
     * Gets the cost of the material.
     *
     * @return The cost of the material.
     */
    @Override
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost of the material.
     *
     * @param cost The cost of the material.
     * @throws IllegalArgumentException if the cost is less than or equal to zero.
     */
    public void setCost(double cost) {
        if (cost <= 0) {
            throw new IllegalArgumentException("Incorrect cost.");
        } else {
            this.cost = cost;
        }
    }

    /**
     * Gets the amount of the material.
     *
     * @return The amount of the material.
     */
    @Override
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the material.
     *
     * @param amount The amount of the material.
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
     * Gets the expiration date of the material.
     *
     * @return The expiration date of the material.
     */
    @Override
    public LocalDate getDate() {
        return expirationDate;
    }

    /**
     * Sets the expiration date of the material.
     *
     * @param expirationDate The expiration date of the material.
     */
    public void setDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Displays information about the material.
     */
    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName() + "\n Purpose: " + getUtility().name() + "\n Cost: " + getCost() + "\n Amount: " + getAmount()
                + "\n Expiration date: " + getDate().toString());
    }

    /**
     * Checks if the material is overdue based on its expiration date.
     *
     * @return True if the material is overdue, false otherwise.
     */
    @Override
    public boolean isOverdue() {
        return !getDate().isAfter(LocalDate.now());
    }
}
