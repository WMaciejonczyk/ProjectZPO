import java.time.LocalDate;
import java.util.Arrays;

public class Medicine implements Supply {
    private String name;
    private String classificationATC;
    private double cost;
    private int amount;
    private LocalDate terminationDate;
    public Medicine(String name, String classificationATC, double cost, int amount, LocalDate terminationDate) {
        String[] stringArray = {"A", "B", "C", "D", "G", "H", "J", "L", "M", "N", "P", "R", "S", "V"};
        classificationATC = classificationATC.toUpperCase();
        if (classificationATC.length() != 7 || !Arrays.asList(stringArray).contains(Character.toString(classificationATC.charAt(0)))) {
            throw new IllegalArgumentException("Inserted invalid ATC code - length or category");
        }
        else if (!Character.isDigit(classificationATC.charAt(1)) || !Character.isDigit(classificationATC.charAt(2)) || !Character.isDigit(classificationATC.charAt(5)) || !Character.isDigit(classificationATC.charAt(6))) {
            throw new IllegalArgumentException("Inserted invalid ATC code - numeric part");
        }
        else if (!Character.isLetter(classificationATC.charAt(3)) || !Character.isLetter(classificationATC.charAt(4))) {
            throw new IllegalArgumentException("Inserted invalid ATC code - alphabetic part");
        }
        else if (cost <= 0) {
            throw new IllegalArgumentException("Inserted invalid cost");
        }
        else if (amount < 0) {
            throw new IllegalArgumentException("Inserted invalid amount");
        }
        else {
            this.name = name;
            this.classificationATC = classificationATC.toUpperCase();
            this.cost = cost;
            this.amount = amount;
            this.terminationDate = terminationDate;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassificationATC() {
        return classificationATC;
    }

    public void setClassificationATC(String classificationATC) {
        String[] stringArray = {"A", "B", "C", "D", "G", "H", "J", "L", "M", "N", "P", "R", "S", "V"};
        classificationATC = classificationATC.toUpperCase();
        if (classificationATC.length() != 7 || !Arrays.asList(stringArray).contains(Character.toString(classificationATC.charAt(0)))) {
            throw new IllegalArgumentException("Inserted invalid ATC code");
        }
        else if (!Character.isDigit(classificationATC.charAt(1)) || !Character.isDigit(classificationATC.charAt(2)) || !Character.isDigit(classificationATC.charAt(5)) || !Character.isDigit(classificationATC.charAt(6))) {
            throw new IllegalArgumentException("Inserted invalid ATC code");
        }
        else if (!Character.isLetter(classificationATC.charAt(3)) || !Character.isLetter(classificationATC.charAt(4))) {
            throw new IllegalArgumentException("Inserted invalid ATC code");
        }
        else {
            this.classificationATC = classificationATC;
        }
    }

    @Override
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost <= 0) {
            throw new IllegalArgumentException("Inserted invalid cost");
        }
        else {
            this.cost = cost;
        }
    }

    @Override
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Inserted invalid amount");
        }
        else {
            this.amount = amount;
        }
    }

    @Override
    public LocalDate getDate() {
        return terminationDate;
    }

    public void setDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }

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
            case 'V'-> "Various";
            default -> throw new IllegalArgumentException("Medicine does not fit in any pharmacological group.");
        };
    }

    @Override
    public void displayInfo() {
        System.out.println("ATC: " + getClassificationATC() + "\n Name: " + getName() + "\n Group: " + getATCGroup()
                + "\n Cost: " + getCost() + "\n Amount: " + getAmount() + "\n Termination date: " + getDate().toString());
    }

    @Override
    public boolean isOverdue() {
        return !getDate().isAfter(LocalDate.now());
    }
}