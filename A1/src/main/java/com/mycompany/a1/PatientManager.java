package com.mycompany.a1;

import java.util.HashMap;

public class PatientManager {

    private HashMap<String, Patient> patients = new HashMap<>();

    public void addPatient(Patient p) {
        if (patients.containsKey(p.getId())) {
            System.out.println("A patient with this ID already exists.");
        } else {
            patients.put(p.getId(), p);
            System.out.println("Patient added successfully.");
        }
    }

    public Patient findPatient(String id) {
        return patients.get(id); // returns null if not found
    }

    public boolean updatePatient(String id) {
        return patients.containsKey(id);
    }
}
