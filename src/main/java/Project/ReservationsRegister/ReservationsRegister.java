package Project.ReservationsRegister;

import java.util.TreeMap;

import Project.reservation.Reservation;
/**
 * Manages a register of reservations.
 */
public class ReservationsRegister {
    private TreeMap<Integer, Reservation> reservations = new TreeMap<>();

    /**
     * Constructs an empty ReservationsRegister.
     */
    public ReservationsRegister() {}

    /**
     * Gets the TreeMap of reservations.
     *
     * @return The TreeMap of reservations.
     */
    public TreeMap<Integer, Reservation> getReservations() {
        return reservations;
    }

    /**
     * Sets the TreeMap of reservations.
     *
     * @param reservations The TreeMap of reservations to set.
     */
    public void setReservations(TreeMap<Integer, Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * Adds a reservation to the register.
     *
     * @param reservation The reservation to add.
     */
    public void addReservation(Reservation reservation) {
        if (getReservations().isEmpty()) {
            getReservations().put(1, reservation);
        } else {
            int key = getReservations().lastKey();
            getReservations().put(key + 1, reservation);
        }
    }

    /**
     * Deletes a reservation from the register.
     *
     * @param key The key of the reservation to delete.
     */
    public void deleteReservation(int key) {
        getReservations().remove(key);
    }

    /**
     * Displays information of a reservation.
     *
     * @param key The key of the reservation to display information for.
     * @throws IllegalArgumentException If no registered reservations are found or if the specified reservation is not found.
     */
    public void displayReservationInfo(int key) {
        if (getReservations().isEmpty()) {
            throw new IllegalArgumentException("No registered reservations.");
        } else {
            if (getReservations().containsKey(key)) {
                Reservation reservation = getReservations().get(key);
                String doctorID = "Doctor ID: " + reservation.getDoctorId() + "\n";
                String reservationStart = "Reservation start: " + reservation.getReservationStart() + "\n";
                String reservationEnd = "Reservation end: " + reservation.getReservationEnd() + "\n";
                String equipmentType = "Equipment name: " + reservation.getEquipmentType() + "\n";
                String equipmentAmount = "Equipment amount: " + reservation.getEquipmentAmount() + "\n";
                String materialName = "Material name: " + reservation.getMaterialType() + "\n";
                String materialAmount = "Material amount: " + reservation.getMaterialAmount() + "\n";
                String medicineATC = "Medicine name: " + reservation.getMedicineATC() + "\n";
                String medicineAmount = "Medicine amount: " + reservation.getMedicineAmount() + "\n";
                String info = doctorID + reservationStart + reservationEnd + equipmentType + equipmentAmount + materialName + materialAmount + medicineATC + medicineAmount;
                System.out.println(info);
            } else {
                throw new IllegalArgumentException("No reservation with this key.");
            }
        }
    }
}