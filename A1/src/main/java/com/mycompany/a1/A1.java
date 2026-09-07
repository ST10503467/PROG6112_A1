package com.mycompany.a1;

import java.util.Scanner;

public class A1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientManager manager = new PatientManager();
        BedManager bedManager = new BedManager();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Hospital Patient System ---");
            System.out.println("1. Add new patient");
            System.out.println("2. Search patient by ID");
            System.out.println("3. Update patient details.");
            System.out.println("4. Exit");
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
                    System.out.print("Enter patient ID to update: ");
                    String updateId = scanner.nextLine();
                    Patient toUpdate = manager.findPatient(updateId);

                    if (toUpdate == null) {
                        System.out.println("No patient found with that ID.");
                        break;
                    }

                    System.out.println("Leave a field blank to keep its current value.");

                    System.out.print("New name [" + toUpdate.getName() + "]: ");
                    String newName = scanner.nextLine();
                    if (!newName.isBlank()) {
                        toUpdate.setName(newName);
                    }

                    System.out.print("New age [" + toUpdate.getAge() + "]: ");
                    String newAgeInput = scanner.nextLine();
                    if (!newAgeInput.isBlank()) {
                        toUpdate.setAge(Integer.parseInt(newAgeInput));
                    }

                    System.out.print("New gender [" + toUpdate.getGender() + "]: ");
                    String newGender = scanner.nextLine();
                    if (!newGender.isBlank()) {
                        toUpdate.setGender(newGender);
                    }

                    Category newCategory = null;
                    while (newCategory == null) {
                        System.out.print("New category [" + toUpdate.getCategory() + "] (Inpatient, Outpatient, Emergency, or blank to keep): ");
                        String newCategoryInput = scanner.nextLine().trim().toUpperCase();
                        if (newCategoryInput.isBlank()) {
                            newCategory = toUpdate.getCategory(); // keep existing
                        } else {
                            try {
                                newCategory = Category.valueOf(newCategoryInput);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid category. Please enter Inpatient, Outpatient, Emergency, or leave blank.");
                            }
                        }
                    }
                    toUpdate.setCategory(newCategory);

                    System.out.print("New condition [" + toUpdate.getCondition() + "]: ");
                    String newCondition = scanner.nextLine();
                    if (!newCondition.isBlank()) {
                        toUpdate.setCondition(newCondition);
                    }

                    System.out.println("Patient updated successfully.");
                    break;

                case "4":
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
