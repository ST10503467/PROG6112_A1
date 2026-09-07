package com.mycompany.a1;

public class Bed {
    private String bedId;
    private boolean occupied;
    private String patientId; // null if unoccupied

    public Bed(String bedId) {
        this.bedId = bedId;
        this.occupied = false;
        this.patientId = null;
    }

    public String getBedId() { return bedId; }
    public boolean isOccupied() { return occupied; }
    public String getPatientId() { return patientId; }

    public void occupy(String patientId) {
        this.occupied = true;
        this.patientId = patientId;
    }

    public void release() {
        this.occupied = false;
        this.patientId = null;
    }

    @Override
    public String toString() {
        return occupied ? bedId + " (Occupied - Patient " + patientId + ")" : bedId + " (Available)";
    }
}
