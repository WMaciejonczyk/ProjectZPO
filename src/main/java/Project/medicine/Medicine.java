package Project.medicine;

import Project.supply.Supply;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * This class represents medicines used as part of medical supplies. It implements the Supply interface.
 */
public class Medicine implements Supply {
    public String name;
    public String classificationATC;
    public double cost;
    public int amount;
    public LocalDate expirationDate;

    /**
     * Constructs a Medicine object with specified parameters.
     *
     * @param name              The name of the medicine.
     * @param classificationATC The Anatomical Therapeutic Chemical (ATC) classification code of the medicine.
     * @param cost              The cost of the medicine.
     * @param amount            The amount of the medicine.
     * @param expirationDate   The expiration date of the medicine.
     * @throws IllegalArgumentException if any of the parameters are invalid.
     */
    public Medicine(String name, String classificationATC, double cost, int amount, LocalDate expirationDate) {
        String[] stringArray = {"A", "B", "C", "D", "G", "H", "J", "L", "M", "N", "P", "R", "S", "V"};
        classificationATC = classificationATC.toUpperCase();
        if (classificationATC.length() != 7 || !Arrays.asList(stringArray).contains(Character.toString(classificationATC.charAt(0)))) {
            throw new IllegalArgumentException("Inserted invalid ATC code - length or category.");
        } else if (!Character.isDigit(classificationATC.charAt(1)) || !Character.isDigit(classificationATC.charAt(2)) || !Character.isDigit(classificationATC.charAt(5)) || !Character.isDigit(classificationATC.charAt(6))) {
            throw new IllegalArgumentException("Inserted invalid ATC code - numeric part.");
        } else if (!Character.isLetter(classificationATC.charAt(3)) || !Character.isLetter(classificationATC.charAt(4))) {
            throw new IllegalArgumentException("Inserted invalid ATC code - alphabetic part.");
        } else if (cost <= 0 || amount <= 0 || name.isEmpty()) {
            throw new IllegalArgumentException("Incorrect parameters.");
        } else {
            this.name = name;
            this.classificationATC = classificationATC;
            this.cost = cost;
            this.amount = amount;
            this.expirationDate = expirationDate;
        }
    }

    /**
     * Gets the name of the medicine.
     *
     * @return The name of the medicine.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the medicine.
     *
     * @param name The name of the medicine.
     * @throws IllegalArgumentException if the name is empty.
     */
    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Incorrect name.");
        } else {
            this.name = name;
        }
    }

    /**
     * Gets the Anatomical Therapeutic Chemical (ATC) classification code of the medicine.
     *
     * @return The ATC classification code of the medicine.
     */
    public String getClassificationATC() {
        return classificationATC;
    }

    /**
     * Sets the Anatomical Therapeutic Chemical (ATC) classification code of the medicine.
     *
     * @param classificationATC The ATC classification code of the medicine.
     * @throws IllegalArgumentException if the classification code is invalid.
     */
    public void setClassificationATC(String classificationATC) {
        String[] stringArray = {"A", "B", "C", "D", "G", "H", "J", "L", "M", "N", "P", "R", "S", "V"};
        classificationATC = classificationATC.toUpperCase();
        if (classificationATC.length() != 7 || !Arrays.asList(stringArray).contains(Character.toString(classificationATC.charAt(0)))) {
            throw new IllegalArgumentException("Inserted invalid ATC code - length or category.");
        } else if (!Character.isDigit(classificationATC.charAt(1)) || !Character.isDigit(classificationATC.charAt(2)) || !Character.isDigit(classificationATC.charAt(5)) || !Character.isDigit(classificationATC.charAt(6))) {
            throw new IllegalArgumentException("Inserted invalid ATC code - numeric part.");
        } else if (!Character.isLetter(classificationATC.charAt(3)) || !Character.isLetter(classificationATC.charAt(4))) {
            throw new IllegalArgumentException("Inserted invalid ATC code - alphabetical part.");
        } else {
            this.classificationATC = classificationATC;
        }
    }

    /**
     * Gets the cost of the medicine.
     *
     * @return The cost of the medicine.
     */
    @Override
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost of the medicine.
     *
     * @param cost The cost of the medicine.
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
     * Gets the amount of the medicine.
     *
     * @return The amount of the medicine.
     */
    @Override
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the medicine.
     *
     * @param amount The amount of the medicine.
     * @throws IllegalArgumentException if the amount is less than or equal to zero.
     */
    public void setAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Incorrect amount.");
        } else {
            this.amount = amount;
        }
    }

    /**
     * Gets the expiration date of the medicine.
     *
     * @return The expiration date of the medicine.
     */
    @Override
    public LocalDate getDate() {
        return expirationDate;
    }

    /**
     * Sets the expiration date of the medicine.
     *
     * @param expirationDate The expiration date of the medicine.
     */
    public void setDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Gets the ATC group (Anatomical Therapeutic Chemical group) of the medicine.
     *
     * @return The ATC group of the medicine.
     */
    public String getATCGroup() {
        return switch (getClassificationATC().charAt(0)) {
            case 'A' -> "Alimentary tract and metabolism";
            case 'B' -> "Blood and blood-forming organs";
            case 'C' -> "Cardiovascular system";
            case 'D' -> "Dermatologicals";
            case 'G' -> "Genito-urinary system and sex hormones";
            case 'H' -> "Systemic hormonal preparations, excluding sex hormones and insulins";
            case 'J' -> "Antiinfectives for systemic use";
            case 'L' -> "Antineoplastic and immunomodulating agents";
            case 'M' -> "Musculo-skeletal system";
            case 'N' -> "Nervous system";
            case 'P' -> "Antiparasitic products, insecticides, and repellents";
            case 'R' -> "Respiratory system";
            case 'S' -> "Sensory organs";
            case 'V' -> "Various";
            default -> throw new IllegalArgumentException("Medicine does not fit in any pharmacological group.");
        };
    }

    /**
     * Displays information about the medicine.
     */
    @Override
    public void displayInfo() {
        System.out.println("ATC: " + getClassificationATC() + "\n Name: " + getName() + "\n Group: " + getATCGroup()
                + "\n Cost: " + getCost() + "\n Amount: " + getAmount() + "\n Expiration date: " + getDate().toString());
    }

    /**
     * Checks if the medicine is expired based on its expiration date.
     *
     * @return True if the medicine is expired, false otherwise.
     */
    @Override
    public boolean isOverdue() {
        return !getDate().isAfter(LocalDate.now());
    }
}