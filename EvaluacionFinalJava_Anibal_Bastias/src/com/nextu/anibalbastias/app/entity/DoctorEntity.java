package com.nextu.anibalbastias.app.entity;

/**
 *
 * @author anibalbastias
 */

public class DoctorEntity extends PersonEntity {
    private String speciality;

    public DoctorEntity(String firstName, String lastName, String speciality) {
        super(firstName, lastName);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Doctor: " + 
                "id = " + id + 
                ", firstName = " + firstName + 
                ", lastName = " + lastName + 
                ", speciality = " + speciality + '\n';
    }
    
    
}
