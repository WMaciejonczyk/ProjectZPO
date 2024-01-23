import java.time.LocalDate;

public class Materials implements Supply {
    public enum Utility {
        HEMORRHAGE_CONTROL,
        STERILIZATION,
        IMMOBILIZATION,
        OTHER
    }
    private String name;
    private double cost;
    private int amount;
    private LocalDate terminationDate;
    private Utility utility;

    public Materials(String name, double cost, int amount, LocalDate terminationDate) {
        this.name = name;
        this.cost = cost;
        this.amount = amount;
        this.terminationDate = terminationDate;
        setUtility();
    }

    public Utility getUtility() {
        return utility;
    }

    public void setUtility() {
        switch (getName().toUpperCase()) {
            case "BANDAGES" -> this.utility = Utility.HEMORRHAGE_CONTROL;
            case "GAUZE" -> this.utility = Utility.STERILIZATION;
            case "PLASTER" -> this.utility = Utility.IMMOBILIZATION;
            default -> this.utility = Utility.OTHER;
        }
    }
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName() + "\n Purpose: " + getUtility().name() + "\n Cost: " + getCost() + "\n Amount: " + getAmount()
        + "\n Termination date: " + getDate().toString());
    }

    @Override
    public boolean isOverdue() {
        return !getDate().isAfter(LocalDate.now());
    }
}