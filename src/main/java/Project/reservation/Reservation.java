package Project.reservation;

import java.time.LocalDate;

import Project.equipment.EquipmentType;
import Project.material.Utility;
/**
 * Represents a reservation for equipment, material, and medicine by a doctor.
 */
public class Reservation {
    public String doctorId;
    public LocalDate reservationStart;
    public LocalDate reservationEnd;
    public EquipmentType equipmentType;
    public int equipmentAmount;
    public Utility materialType;
    public int materialAmount;
    public String medicineATC;
    public int medicineAmount;

    /**
     * Constructs a Reservation with the specified details.
     *
     * @param doctorId        The ID of the doctor making the reservation.
     * @param reservationStart The start date of the reservation.
     * @param reservationEnd   The end date of the reservation.
     * @param equipmentType    The type of equipment being reserved.
     * @param equipmentAmount  The amount of equipment being reserved.
     * @param materialType     The type of material being reserved.
     * @param materialAmount   The amount of material being reserved.
     * @param medicineATC      The ATC code of the medicine being reserved.
     * @param medicineAmount   The amount of medicine being reserved.
     */
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

    /**
     * Gets the ID of the doctor making the reservation.
     *
     * @return The doctor ID.
     */
    public String getDoctorId() {
        return doctorId;
    }

    /**
     * Sets the ID of the doctor making the reservation.
     *
     * @param doctorId The doctor ID to set.
     */
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * Gets the start date of the reservation.
     *
     * @return The reservation start date.
     */
    public LocalDate getReservationStart() {
        return reservationStart;
    }

    /**
     * Sets the start date of the reservation.
     *
     * @param reservationStart The reservation start date to set.
     */
    public void setReservationStart(LocalDate reservationStart) {
        this.reservationStart = reservationStart;
    }

    /**
     * Gets the end date of the reservation.
     *
     * @return The reservation end date.
     */
    public LocalDate getReservationEnd() {
        return reservationEnd;
    }

    /**
     * Sets the end date of the reservation.
     *
     * @param reservationEnd The reservation end date to set.
     */
    public void setReservationEnd(LocalDate reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    /**
     * Gets the type of equipment being reserved.
     *
     * @return The equipment type.
     */
    public String getEquipmentType() {
        return equipmentType.toString();
    }

    /**
     * Sets the type of equipment being reserved.
     *
     * @param equipmentType The equipment type to set.
     */
    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    /**
     * Gets the amount of equipment being reserved.
     *
     * @return The equipment amount.
     */
    public int getEquipmentAmount() {
        return equipmentAmount;
    }

    /**
     * Sets the amount of equipment being reserved.
     *
     * @param equipmentAmount The equipment amount to set.
     */
    public void setEquipmentAmount(int equipmentAmount) {
        this.equipmentAmount = equipmentAmount;
    }

    /**
     * Gets the type of material being reserved.
     *
     * @return The material type.
     */
    public String getMaterialType() {
        return materialType.toString();
    }

    /**
     * Sets the type of material being reserved.
     *
     * @param materialType The material type to set.
     */
    public void setmaterialType(Utility materialType) {
        this.materialType = materialType;
    }

    /**
     * Gets the amount of material being reserved.
     *
     * @return The material amount.
     */
    public int getMaterialAmount() {
        return materialAmount;
    }

    /**
     * Sets the amount of material being reserved.
     *
     * @param materialAmount The material amount to set.
     */
    public void setMaterialAmount(int materialAmount) {
        this.materialAmount = materialAmount;
    }

    /**
     * Gets the ATC code of the medicine being reserved.
     *
     * @return The medicine ATC code.
     */
    public String getMedicineATC() {
        return medicineATC;
    }

    /**
     * Sets the ATC code of the medicine being reserved.
     *
     * @param medicineATC The medicine ATC code to set.
     */
    public void setMedicineATC(String medicineATC) {
        this.medicineATC = medicineATC;
    }

    /**
     * Gets the amount of medicine being reserved.
     *
     * @return The medicine amount.
     */
    public int getMedicineAmount() {
        return medicineAmount;
    }

    /**
     * Sets the amount of medicine being reserved.
     *
     * @param medicineAmount The medicine amount to set.
     */
    public void setMedicineAmount(int medicineAmount) {
        this.medicineAmount = medicineAmount;
    }
}