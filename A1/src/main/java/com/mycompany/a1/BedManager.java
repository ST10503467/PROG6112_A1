package com.mycompany.a1;

import java.util.ArrayList;
import java.util.List;

public class BedManager {

    private static final int ROWS = 4;
    private static final int COLS = 5;
    private Bed[] beds;

    public BedManager() {
        beds = new Bed[ROWS * COLS];
        for (int i = 0; i < beds.length; i++) {
            beds[i] = new Bed(String.format("B%02d", i + 1));
        }
    }

    public String allocateBed(Patient patient) {
        if (patient.getCategory() != Category.INPATIENT) {
            System.out.println("Only inpatients may be allocated a bed.");
            return null;
        }

        for (Bed bed : beds) {
            if (!bed.isOccupied()) {
                bed.occupy(patient.getId());
                return bed.getBedId();
            }
        }

        System.out.println("No beds available.");
        return null;
    }

    public boolean releaseBed(String bedId) {
        Bed bed = findBed(bedId);
        if (bed == null) {
            System.out.println("No such bed exists.");
            return false;
        }
        if (!bed.isOccupied()) {
            System.out.println("That bed is already free.");
            return false;
        }
        bed.release();
        return true;
    }

    public String releaseBedByPatientId(String patientId) {
        for (Bed bed : beds) {
            if (bed.isOccupied() && bed.getPatientId().equals(patientId)) {
                bed.release();
                return bed.getBedId();
            }
        }
        return null;
    }

    private Bed findBed(String bedId) {
        for (Bed bed : beds) {
            if (bed.getBedId().equalsIgnoreCase(bedId)) {
                return bed;
            }
        }
        return null;
    }

    public void displayWardLayout() {
        System.out.println("\n--- Ward Layout ---");
        for (int row = 0; row < ROWS; row++) {
            StringBuilder line = new StringBuilder();
            for (int col = 0; col < COLS; col++) {
                Bed bed = beds[row * COLS + col];
                String marker = bed.isOccupied() ? "[X]" : "[ ]";
                line.append(bed.getBedId()).append(marker).append("  ");
            }
            System.out.println(line);
        }
    }

    public List<Bed> getAvailableBeds() {
        List<Bed> available = new ArrayList<>();
        for (Bed bed : beds) {
            if (!bed.isOccupied()) {
                available.add(bed);
            }
        }
        return available;
    }

    public List<Bed> getOccupiedBeds() {
        List<Bed> occupied = new ArrayList<>();
        for (Bed bed : beds) {
            if (bed.isOccupied()) {
                occupied.add(bed);
            }
        }
        return occupied;
    }

    public int getTotalBeds() {
        return beds.length;
    }

    public double getOccupancyPercentage() {
        return (getOccupiedBeds().size() * 100.0) / getTotalBeds();
    }
}
