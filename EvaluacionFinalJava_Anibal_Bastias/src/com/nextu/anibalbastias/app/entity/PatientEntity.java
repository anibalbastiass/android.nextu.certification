package com.nextu.anibalbastias.app.entity;

/**
 *
 * @author anibalbastias
 */

public class PatientEntity extends PersonEntity {
    private int age;
    private String gender;

    public PatientEntity(
            String firstName, 
            String lastName, 
            int age, 
            String gender) {
        super(firstName, lastName);
        this.age = age;
        this.gender = gender;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient: " + 
                "id = " + id + 
                ", firstName = " + firstName + 
                ", lastName = " + lastName + 
                ", age = " + age + 
                ", gender = " + gender + '\n';
    }
    
    
}
