package Project.reservation;

import java.time.LocalDate;

import Project.equipment.EquipmentType;
import Project.material.Utility;

public class Reservation {
    private String doctorId;
    private LocalDate reservationStart;
    private LocalDate reservationEnd;
    private EquipmentType equipmentType;
    private int equipmentAmount;
    private Utility materialType;
    private int materialAmount;
    private String medicineATC;
    private int medicineAmount;

    public Reservation(String doctorId, LocalDate reservationStart, LocalDate reservationEnd,
                       EquipmentType equipmentType, int equipmentAmount, Utility materialType,
                       int materialAmount, String medicineATC, int medicineAmount) {
        this.doctorId = doctorId;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.equipmentType = equipmentType;
        this.equipmentAmount = equipmentAmount;
        this.materialType = materialType;
        this.materialAmount = materialAmount;
        this.medicineATC = medicineATC;
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

    public String getEquipmentType() {
        return equipmentType.toString();
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public int getEquipmentAmount() {
        return equipmentAmount;
    }

    public void setEquipmentAmount(int equipmentAmount) {
        this.equipmentAmount = equipmentAmount;
    }

    public String getMaterialType() {
        return materialType.toString();
    }

    public void setmaterialType(Utility materialType) {
        this.materialType = materialType;
    }

    public int getMaterialAmount() {
        return materialAmount;
    }

    public void setMaterialAmount(int materialAmount) {
        this.materialAmount = materialAmount;
    }

    public String getMedicineATC() {
        return medicineATC;
    }

    public void setMedicineATC(String medicineATC) {
        this.medicineATC = medicineATC;
    }

    public int getMedicineAmount() {
        return medicineAmount;
    }

    public void setMedicineAmount(int medicineAmount) {
        this.medicineAmount = medicineAmount;
    }
}