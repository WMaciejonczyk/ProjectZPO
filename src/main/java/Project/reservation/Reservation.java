package Project.reservation;

import java.time.LocalDate;

public class Reservation {
    private String doctorId;
    private LocalDate reservationStart;
    private LocalDate reservationEnd;
    private String equipmentName;
    private int equipmentAmount;
    private String materialName;
    private int materialAmount;
    private String medicineName;
    private int medicineAmount;

    public Reservation(String doctorId, LocalDate reservationStart, LocalDate reservationEnd,
                       String equipmentName, int equipmentAmount, String materialName,
                       int materialAmount, String medicineName, int medicineAmount) {
        this.doctorId = doctorId;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.equipmentName = equipmentName;
        this.equipmentAmount = equipmentAmount;
        this.materialName = materialName;
        this.materialAmount = materialAmount;
        this.medicineName = medicineName;
        this.medicineAmount = medicineAmount;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(LocalDate reservationStart) {
        this.reservationStart = reservationStart;
    }

    public LocalDate getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(LocalDate reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getEquipmentAmount() {
        return equipmentAmount;
    }

    public void setEquipmentAmount(int equipmentAmount) {
        this.equipmentAmount = equipmentAmount;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getMaterialAmount() {
        return materialAmount;
    }

    public void setMaterialAmount(int materialAmount) {
        this.materialAmount = materialAmount;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getMedicineAmount() {
        return medicineAmount;
    }

    public void setMedicineAmount(int medicineAmount) {
        this.medicineAmount = medicineAmount;
    }
}
