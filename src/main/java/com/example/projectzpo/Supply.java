import java.time.LocalDate;

public interface Supply {
    String getName();

    void setName(String name);

    double getCost();

    void setCost(double cost);

    int getAmount();

    void setAmount(int amount);

    LocalDate getDate();

    void setDate(LocalDate date);

    void displayInfo();

    boolean isOverdue();
}
