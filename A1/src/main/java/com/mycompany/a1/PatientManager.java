package com.mycompany.a1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;

public class PatientManager {

    private HashMap<String, Patient> patients = new HashMap<>();

    public boolean addPatient(Patient p) {
        if (patients.containsKey(p.getId())) {
            System.out.println("A patient with this ID already exists.");
            return false;
        }
        patients.put(p.getId(), p);
        System.out.println("Patient added successfully.");
        return true;
    }

    public Patient findPatient(String id) {
        return patients.get(id);
    }

    public boolean deletePatient(String id) {
        if (patients.containsKey(id)) {
            patients.remove(id);
            return true;
        }
        return false;
    }

    public Collection<Patient> getAllPatients() {
        return patients.values();
    }

    public List<Patient> getPatientsSortedById() {
        List<Patient> list = new ArrayList<>(patients.values());
        list.sort(Comparator.comparing(Patient::getId));
        return list;
    }

    public List<Patient> getPatientsSortedByName() {
        List<Patient> list = new ArrayList<>(patients.values());
        list.sort(Comparator.comparing(Patient::getName));
        return list;
    }
}
