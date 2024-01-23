import java.time.LocalDate;

public class Equipment implements Supply {
    public enum EquipmentType {
        EKG,
        RTG,
        USG,
        MRI,
        OTHER
    }

    public enum Mobility {
        MOVABLE,
        IMMOVABLE,
        UNDETERMINED
    }
    private String name;

    private double cost;

    private int amount;

    private LocalDate serviceDate;
    private EquipmentType equipmentType;
    private Mobility mobility;

    public Equipment(String name, double cost, int amount, LocalDate serviceDate) {
        this.name = name.toUpperCase();
        this.cost = cost;
        this.amount = amount;
        this.serviceDate = serviceDate;
        setEquipmentType();
        setMobility();
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType() {
        switch (getName()) {
            case "EKG" -> this.equipmentType = EquipmentType.EKG;
            case "RTG" -> this.equipmentType = EquipmentType.RTG;
            case "USG" -> this.equipmentType = EquipmentType.USG;
            case "MRI" -> this.equipmentType = EquipmentType.MRI;
            default -> this.equipmentType = EquipmentType.OTHER;
        }
    }

    public Mobility getMobility() {
        return mobility;
    }

    public void setMobility() {
        switch (getName()) {
            case "EKG", "USG" -> this.mobility = Mobility.MOVABLE;
            case "RTG", "MRI" -> this.mobility = Mobility.IMMOVABLE;
            default -> this.mobility = Mobility.UNDETERMINED;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
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
        return serviceDate;
    }

    public void setDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }


    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName() + "\n Cost: " + getCost() + "\n Amount: " + getAmount()
                + "\n Service date: " + getDate().toString());
    }

    @Override
    public boolean isOverdue() {
        return !getDate().isAfter(LocalDate.now());
    }
}