package com.mycompany.a1;

import java.util.Scanner;

public class A1 {

    // public class Patient {

        // private String patientID;
        // private String patientName;
        // private int patientAge;
        // private String patientGender;
        // private String patientCondition;
        // private String patientCategory;

    // }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {

            System.out.println("\n Main Menu");
            System.out.println("1. Register a patient.");
            System.out.println("2. Search for a patient.");
            System.out.println("3. Update patient details.");
            System.out.println("4. Delete a patient.");
            System.out.println("5. Display all patients.");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter patient ID: ");
                    String patientID = scanner.nextLine();
                    System.out.println("Patient ID registered.");

                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.println("Patient name registered.");

                    System.out.print("Enter patient age: ");
                    String patientAge = scanner.nextLine();
                    int patientAgeInt = Integer.parseInt(patientAge);           // This must be parse'd into an integer.
                    System.out.println("Patient age registered.");

                    System.out.print("Enter patient gender: ");
                    String patientGender = scanner.nextLine();
                    System.out.println("Patient gender registered.");

                    System.out.print("Enter patient condition: ");
                    String patientCondition = scanner.nextLine();
                    System.out.println("Patient condition registered.");

                    System.out.print("Enter patient category (Inpatient, Outpatient, or Emergency): ");
                    String patientCategory = scanner.nextLine();
                    System.out.println("Patient category registered.");

                    System.out.println("Patient ID: " + patientID);
                    System.out.println("Patient name: " + patientName);
                    System.out.println("Patient age: " + patientAgeInt);
                    System.out.println("Patient gender: " + patientGender);
                    System.out.println("Patient condition: " + patientCondition);
                    System.out.println("Patient category: " + patientCategory);
                    break;
                case "2":
                    System.out.println("Enter patient ID: ");
                    break;
            }
        }
    }
}
