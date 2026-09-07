package com.mycompany.a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BedManagerTest {

    private BedManager bedManager;
    private Patient inpatient;

    @BeforeEach
    void setUp() {
        bedManager = new BedManager();
        inpatient = new Patient("P01", "Sipho Ndlovu", 45, "Male", Category.INPATIENT, "Stable");
    }

    @Test
    void testAllocateBed() {
        String bedId = bedManager.allocateBed(inpatient);
        assertNotNull(bedId);
        assertTrue(bedManager.getOccupiedBeds().size() == 1);
    }

    @Test
    void testAllocateBedRejectsNonInpatient() {
        Patient outpatient = new Patient("P02", "Jane Doe", 30, "Female", Category.OUTPATIENT, "Fine");
        assertNull(bedManager.allocateBed(outpatient));
    }

    @Test
    void testReleaseBed() {
        String bedId = bedManager.allocateBed(inpatient);
        assertTrue(bedManager.releaseBed(bedId));
        assertEquals(20, bedManager.getAvailableBeds().size());
    }

    @Test
    void testPreventAllocatingOccupiedBed() {
        assertTrue(bedManager.allocateSpecificBed("B01", inpatient));

        Patient anotherInpatient = new Patient("P02", "Jane Doe", 30, "Female", Category.INPATIENT, "Stable");
        assertFalse(bedManager.allocateSpecificBed("B01", anotherInpatient)); // already occupied
    }

    @Test
    void testPreventAllocationWhenAllBedsOccupied() {
        // Fill all 20 beds
        for (int i = 1; i <= 20; i++) {
            Patient p = new Patient("P" + i, "Patient " + i, 30, "Male", Category.INPATIENT, "Stable");
            assertNotNull(bedManager.allocateBed(p));
        }

        // 21st patient should be rejected
        Patient overflow = new Patient("P21", "Overflow Patient", 30, "Male", Category.INPATIENT, "Stable");
        assertNull(bedManager.allocateBed(overflow));
    }
}