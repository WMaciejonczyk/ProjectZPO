package Project;

import java.time.LocalDate;

/**
 * The Supply interface represents a medical supply item.
 */
public interface Supply {

    /**
     * Gets the name of the supply.
     *
     * @return The name of the supply.
     */
    String getName();

    /**
     * Sets the name of the supply.
     *
     * @param name The name of the supply.
     */
    void setName(String name);

    /**
     * Gets the cost of the supply.
     *
     * @return The cost of the supply.
     */
    double getCost();

    /**
     * Sets the cost of the supply.
     *
     * @param cost The cost of the supply.
     */
    void setCost(double cost);

    /**
     * Gets the amount of the supply.
     *
     * @return The amount of the supply.
     */
    int getAmount();

    /**
     * Sets the amount of the supply.
     *
     * @param amount The amount of the supply.
     */
    void setAmount(int amount);

    /**
     * Gets the date associated with the supply.
     *
     * @return The date associated with the supply.
     */
    LocalDate getDate();

    /**
     * Sets the date associated with the supply.
     *
     * @param date The date associated with the supply.
     */
    void setDate(LocalDate date);

    /**
     * Displays information about the supply.
     */
    void displayInfo();

    /**
     * Checks if the supply is overdue.
     *
     * @return True if the supply is overdue, false otherwise.
     */
    boolean isOverdue();
}
