package com.mycompany.a1;

import java.util.Scanner;

public class A1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientManager manager = new PatientManager();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Hospital Patient System ---");
            System.out.println("1. Add new patient");
            System.out.println("2. Search patient by ID");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();

                    Category category = null;
                    while (category == null) {
                        System.out.print("Enter category (Inpatient, Outpatient, Emergency): ");
                        String categoryInput = scanner.nextLine().trim().toUpperCase();
                        try {
                            category = Category.valueOf(categoryInput);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid category. Please enter Inpatient, Outpatient, or Emergency.");
                        }
                    }

                    System.out.print("Enter condition: ");
                    String condition = scanner.nextLine();

                    manager.addPatient(new Patient(id, name, age, gender, category, condition));
                    break;

                case "2":
                    System.out.print("Enter patient ID to search: ");
                    String searchId = scanner.nextLine();
                    Patient found = manager.findPatient(searchId);

                    if (found != null) {
                        System.out.println("\n" + found);
                    } else {
                        System.out.println("No patient found with that ID.");
                    }
                    break;

                case "3":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }

        scanner.close();
    }
}
