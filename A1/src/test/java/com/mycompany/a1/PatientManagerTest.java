package com.mycompany.a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PatientManagerTest {

    private PatientManager manager;

    @BeforeEach
    void setUp() {
        manager = new PatientManager();
    }

    @Test
    void testRegisterPatient() {
        Patient p = new Patient("P01", "Sipho Ndlovu", 45, "Male", Category.INPATIENT, "Stable");
        assertTrue(manager.addPatient(p));
        assertEquals(1, manager.getAllPatients().size());
    }

    @Test
    void testSearchPatient() {
        Patient p = new Patient("P01", "Sipho Ndlovu", 45, "Male", Category.INPATIENT, "Stable");
        manager.addPatient(p);

        Patient found = manager.findPatient("P01");
        assertNotNull(found);
        assertEquals("Sipho Ndlovu", found.getName());

        assertNull(manager.findPatient("P99"));
    }

    @Test
    void testUpdatePatientDetails() {
        Patient p = new Patient("P01", "Sipho Ndlovu", 45, "Male", Category.INPATIENT, "Stable");
        manager.addPatient(p);

        Patient toUpdate = manager.findPatient("P01");
        toUpdate.setCondition("Critical");

        assertEquals("Critical", manager.findPatient("P01").getCondition());
    }

    @Test
    void testDeletePatient() {
        Patient p = new Patient("P01", "Sipho Ndlovu", 45, "Male", Category.INPATIENT, "Stable");
        manager.addPatient(p);

        assertTrue(manager.deletePatient("P01"));
        assertNull(manager.findPatient("P01"));
        assertFalse(manager.deletePatient("P01")); // already gone
    }

    @Test
    void testPreventDuplicatePatientIds() {
        Patient p1 = new Patient("P01", "Sipho Ndlovu", 45, "Male", Category.INPATIENT, "Stable");
        Patient p2 = new Patient("P01", "Different Name", 30, "Female", Category.OUTPATIENT, "Fine");

        assertTrue(manager.addPatient(p1));
        assertFalse(manager.addPatient(p2)); // rejected, same ID

        // original patient's data should be untouched
        assertEquals("Sipho Ndlovu", manager.findPatient("P01").getName());
        assertEquals(1, manager.getAllPatients().size());
    }

    @Test
    void testSortPatientsById() {
        manager.addPatient(new Patient("P03", "Charlie", 20, "Male", Category.OUTPATIENT, "Fine"));
        manager.addPatient(new Patient("P01", "Alice", 25, "Female", Category.INPATIENT, "Stable"));
        manager.addPatient(new Patient("P02", "Bob", 30, "Male", Category.EMERGENCY, "Critical"));

        List<Patient> sorted = manager.getPatientsSortedById();

        assertEquals("P01", sorted.get(0).getId());
        assertEquals("P02", sorted.get(1).getId());
        assertEquals("P03", sorted.get(2).getId());
    }
}
