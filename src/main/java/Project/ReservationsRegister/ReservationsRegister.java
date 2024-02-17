package Project.ReservationsRegister;

import java.util.TreeMap;

import Project.reservation.Reservation;

public class ReservationsRegister {
    private TreeMap<Integer, Reservation> reservations = new TreeMap<>();

    public ReservationsRegister() {}

    public TreeMap<Integer, Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(TreeMap<Integer, Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        if (getReservations().isEmpty()) {
            getReservations().put(1, reservation);
        } else {
            int key = getReservations().lastKey();
            getReservations().put(key + 1, reservation);
        }
    }

    public void deleteReservation(int key) {
        getReservations().remove(key);
    }

    public void displayReservationInfo(int key) {
        if (getReservations().isEmpty()) {
            throw new IllegalArgumentException("No registered reservations.");
        }
        else {
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
            }
            else {
                throw new IllegalArgumentException("No reservation with this key.");
            }
        }
    }

}