package com.mycompany.a1;

public class Patient {

    private String id;
    private String name;
    private int age;
    private String gender;
    private Category category;   // changed from String
    private String condition;

    public void setName(String name) {
        this.name = name;}
    public void setAge(int age) {
        this.age = age;}
    public void setGender(String gender) {
        this.gender = gender;}
    public void setCategory(Category category) {
        this.category = category;}
    public void setCondition(String condition) {
        this.condition = condition;}

    public Patient(String id, String name, int age, String gender, Category category, String condition) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.category = category;
        this.condition = condition;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Category getCategory() {
        return category;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id
                + "\nName: " + name
                + "\nAge: " + age
                + "\nGender: " + gender
                + "\nCategory: " + category
                + "\nCondition: " + condition;
    }
}
